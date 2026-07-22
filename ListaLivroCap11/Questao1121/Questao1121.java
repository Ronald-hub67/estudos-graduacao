public class Questao1121 {

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando programa no main...");

            metodoLocal();

        } catch (ArithmeticException e) {
            System.err.println("\nCapturou: " + e.getMessage());
            System.err.println("O erro escorregou do metodoLocal para o main.");
        }

        System.out.println("\nPrograma finalizado com segurança.");
    }

    public static void metodoLocal() {
        try {
            System.out.println("Tentando executar operações...");

            int resultado = 10 / 0;

            System.out.println("Resultado: " + resultado);

        } catch (NullPointerException e) {
            System.out.println("Capturou NullPointerException.");
        }
    }
}