public class Questao1116 {
    public static void main(String[] args) {
        try {
            throw new ExceptionB("Lançando ExceptionB");
        } catch (ExceptionA e) {
            System.out.println("Capturado por ExceptionA: " + e.getMessage());
        }

        try {
            throw new ExceptionC("Lançando ExceptionC");
        } catch (ExceptionA e) {
            System.out.println("Capturado por ExceptionA: " + e.getMessage());
        }
    }
}