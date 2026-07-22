public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(10, "Ronald");

        conta.depositar(500.0);
        conta.sacar(200.0);
        conta.sacar(400.0);
        conta.depositar(50.0);

        conta.imprimirExtrato();
    }
}