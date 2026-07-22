import java.io.IOException;

public class Questao1117 {
    public static void main(String[] args) {

        try {
            throw new ExceptionA("Erro do tipo ExceptionA");
        } catch (Exception e) {
            System.out.println("Capturado como Exception: " + e.getClass().getName() + " - " + e.getMessage());
        }

        try {
            throw new ExceptionB("Erro do tipo ExceptionB");
        } catch (Exception e) {
            System.out.println("Capturado como Exception: " + e.getClass().getName() + " - " + e.getMessage());
        }

        try {
            throw new NullPointerException("Erro de Referência Nula");
        } catch (Exception e) {
            System.out.println("Capturado como Exception: " + e.getClass().getName() + " - " + e.getMessage());
        }

        try {
            throw new IOException("Erro de Entrada/Saída");
        } catch (Exception e) {
            System.out.println("Capturado como Exception: " + e.getClass().getName() + " - " + e.getMessage());
        }
    }
}