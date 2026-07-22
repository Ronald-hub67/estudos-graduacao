public class Questao1118 {
    public static void main(String[] args) {
        try {
            throw new ExceptionB("Erro tipo B");
        }
        catch (ExceptionB b) {
            System.out.println("Capturado especificamente como ExceptionB: " + b.getMessage());
        }
        catch (ExceptionA a) {
            System.out.println("Capturado genericamente como ExceptionA: " + a.getMessage());
        }
    }
}