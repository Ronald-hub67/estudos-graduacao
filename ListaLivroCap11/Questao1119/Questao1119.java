public class Questao1119 {
    public static void main(String[] args) {
        try {
            System.out.println("Tentando criar um objeto do tipo SomeClass...");
            SomeClass objeto = new SomeClass();

            System.out.println("Objeto criado com sucesso!");

        } catch (Exception e) {
            System.err.println("Capturado erro de construção: " + e.getMessage());
        }

        System.out.println("O programa continua sua execução após o tratamento da falha.");
    }
}