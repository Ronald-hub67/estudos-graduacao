import br.edu.logistica.modelo.*;
import br.edu.logistica.servico.GerenciadorFrota;

import java.util.Scanner;

public class Main {

    static GerenciadorFrota gerenciador = new GerenciadorFrota();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Valor inválido. Escolha: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1 -> gerenciador.listarVeiculosDisponiveis();
                case 2 -> gerenciador.gerarRelatorioAutonomia();
                case 3 -> menuCadastrar();
                case 4 -> menuBuscarPorPlaca();
                case 5 -> menuRastreamento();
                case 0 -> System.out.println("Encerrando o sistema LogiTrack.");
                default -> System.out.println("Opção inválida.");
            }

            System.out.println();

        } while (opcao != 0);

        scanner.close();
    }

    static void exibirMenu() {
        System.out.println("=== LogiTrack ===");
        System.out.println("1 - Listar veículos disponíveis");
        System.out.println("2 - Relatório de autonomia");
        System.out.println("3 - Cadastrar veículo");
        System.out.println("4 - Buscar por placa");
        System.out.println("5 - Rastreamento (Monitoravel)");
        System.out.println("0 - Sair");
    }

    static void menuCadastrar() {
        System.out.println("Tipo de veículo:");
        System.out.println("1 - Caminhão");
        System.out.println("2 - Van");
        int tipo = lerInt("Escolha: ");

        System.out.print("Placa: ");
        String placa = scanner.next().toUpperCase();

        double carga = lerDouble("Capacidade de carga (t): ");

        StatusVeiculo status = lerStatus();
        TipoCombustivel comb  = lerCombustivel();

        if (tipo == 1) {
            int eixos = lerInt("Número de eixos: ");
            gerenciador.adicionarVeiculo(new Caminhao(placa, carga, status, comb, eixos));
        } else if (tipo == 2) {
            int refrig = lerInt("Possui refrigeração? (1-Sim / 2-Não): ");
            gerenciador.adicionarVeiculo(new Van(placa, carga, status, comb, refrig == 1));
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    static void menuBuscarPorPlaca() {
        System.out.print("Digite a placa: ");
        String placa = scanner.next().toUpperCase();

        Veiculo v = gerenciador.buscarPorPlaca(placa);
        if (v != null) {
            System.out.println("Encontrado: " + v.getPlaca()
                    + " | Tipo: "      + v.getClass().getSimpleName()
                    + " | Status: "    + v.getStatus()
                    + " | Autonomia: " + String.format("%.1f", v.calcularAutonomia()) + " km");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    static void menuRastreamento() {
        System.out.print("Digite a placa do caminhão: ");
        String placa = scanner.next().toUpperCase();

        Veiculo v = gerenciador.buscarPorPlaca(placa);
        if (v == null) {
            System.out.println("Veículo não encontrado.");
        } else if (v instanceof Monitoravel m) {
            m.enviarCoordenadas();
            System.out.println(m.obterLocalizacaoAtual());
        } else {
            System.out.println("Este veículo não implementa Monitoravel.");
        }
    }

    static int lerInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido. " + prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    static double lerDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor inválido. " + prompt);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    static StatusVeiculo lerStatus() {
        System.out.println("Status:");
        System.out.println("1 - Disponível");
        System.out.println("2 - Em viagem");
        System.out.println("3 - Em manutenção");
        int op = lerInt("Escolha: ");
        return switch (op) {
            case 2 -> StatusVeiculo.EM_VIAGEM;
            case 3 -> StatusVeiculo.EM_MANUTENCAO;
            default -> StatusVeiculo.DISPONIVEL;
        };
    }

    static TipoCombustivel lerCombustivel() {
        System.out.println("Combustível:");
        System.out.println("1 - Diesel");
        System.out.println("2 - Gasolina");
        System.out.println("3 - Elétrico");
        int op = lerInt("Escolha: ");
        return switch (op) {
            case 2 -> TipoCombustivel.GASOLINA;
            case 3 -> TipoCombustivel.ELETRICO;
            default -> TipoCombustivel.DIESEL;
        };
    }
}