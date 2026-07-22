import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaRH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Criando o HashMap: Chave (CPF) e Valor (Cargo)
        Map<String, String> funcionarios = new HashMap<>();

        // Adicionando 5 funcionários (Ação 1)
        funcionarios.put("123.456.789-00", "Analista de Sistemas");
        funcionarios.put("222.333.444-55", "Gerente de Projetos");
        funcionarios.put("987.654.321-11", "Desenvolvedor Backend");
        funcionarios.put("555.666.777-88", "Designer UX");
        funcionarios.put("111.222.333-44", "Diretor de Tecnologia");

        System.out.println("--- Consulta de Funcionário RH ---");
        
        // Solicitação de busca (Ação 2)
        System.out.print("Digite o CPF para consulta (formato XXX.XXX.XXX-XX): ");
        String cpfBusca = scanner.nextLine();

        // Busca instantânea com .get()
        String cargo = funcionarios.get(cpfBusca);

        if (cargo != null) {
            System.out.println("Cargo encontrado: " + cargo);
        } else {
            System.out.println("Funcionário não encontrado.");
        }

        scanner.close();
    }
}