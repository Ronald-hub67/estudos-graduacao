public class Questao1120 {

    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.err.println("Exceção capturada em someMethod e sendo relançada...");

            throw e;
        }
    }

    public static void someMethod2() throws Exception {
        throw new Exception("Erro original em someMethod2");
    }

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.err.println("Exceção capturada no main:");

            e.printStackTrace();
        }
    }
}