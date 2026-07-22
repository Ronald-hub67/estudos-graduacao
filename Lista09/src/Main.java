import java.util.*;

public class Main {
    private static List<Contato> contatos = new ArrayList<>();
    private static AgendaArquivo agendaRepo = new AgendaArquivo();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            contatos = agendaRepo.carregar();
            ,
            Collections.sort(contatos);
        } catch (Exception e) {
            System.out.println("Aviso: Arquivo de contatos não encontrado ou vazio.");
        }

        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- SISTEMA DE GESTÃO DE CONTATOS ---");
        System.out.println("1 - Adicionar Cliente");
        System.out.println("2 - Adicionar Fornecedor");
        System.out.println("3 - Listar Contatos");
        System.out.println("4 - Buscar por Nome");
        System.out.println("5 - Atualizar Contato");
        System.out.println("6 - Remover Contato");
        System.out.println("0 - Sair e Salvar");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1 -> adicionar(TipoContato.CLIENTE);
            case 2 -> adicionar(TipoContato.FORNECEDOR);
            case 3 -> listar();
            case 4 -> buscar();
            case 5 -> atualizar();
            case 6 -> remover();
            case 0 -> {
                agendaRepo.salvar(contatos);
                System.out.println("Dados salvos. Fechando o sistema.");
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void adicionar(TipoContato tipo) {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();

        for (Contato c : contatos) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                System.out.println("ERRO: Este e-mail já está cadastrado em nossa base.");
                return;
            }
        }

        if (tipo == TipoContato.CLIENTE) {
            System.out.print("Nome da Empresa: "); String empresa = scanner.nextLine();
            contatos.add(new Cliente(nome, email, empresa));
        } else {
            System.out.print("Tipo de Serviço: "); String servico = scanner.nextLine();
            contatos.add(new Fornecedor(nome, email, servico));
        }

        Collections.sort(contatos);
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void listar() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
            return;
        }
        System.out.println("\n--- LISTA DE CONTATOS (ORDEM ALFABÉTICA) ---");
        for (Contato c : contatos) {
            System.out.println(c);
        }
    }

    private static void buscar() {
        System.out.print("Digite parte do nome para busca: ");
        String termo = scanner.nextLine().toLowerCase();
        boolean encontrado = false;

        for (Contato c : contatos) {
            if (c.getNome().toLowerCase().contains(termo)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Nenhum contato encontrado com esse termo.");
    }

    private static void atualizar() {
        System.out.print("Digite o e-mail do contato que deseja atualizar: ");
        String email = scanner.nextLine();

        for (Contato c : contatos) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                System.out.print("Novo Nome: "); c.setNome(scanner.nextLine());

                if (c instanceof Cliente cl) {
                    System.out.print("Nova Empresa: "); cl.setEmpresa(scanner.nextLine());
                } else if (c instanceof Fornecedor f) {
                    System.out.print("Novo Serviço: "); f.setServico(scanner.nextLine());
                }

                Collections.sort(contatos);
                System.out.println("Dados atualizados!");
                return;
            }
        }
        System.out.println("Contato não localizado.");
    }

    private static void remover() {
        System.out.print("Digite o e-mail do contato para remover: ");
        String email = scanner.nextLine();

        boolean removido = contatos.removeIf(c -> c.getEmail().equalsIgnoreCase(email));

        if (removido) {
            System.out.println("Contato removido com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}