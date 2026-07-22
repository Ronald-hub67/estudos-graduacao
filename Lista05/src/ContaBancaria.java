import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private int numeroConta;
    private String titular;
    private double saldo;
    private List<String> historico;

    public ContaBancaria(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
        this.historico.add("Conta criada para: " + titular);
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            historico.add("Depósito de " + valor);
        } else {
            historico.add("Tentativa de depósito inválida: " + valor);
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            historico.add("Saque de " + valor);
        } else if (valor > this.saldo) {
            historico.add("Saldo insuficiente");
        } else {
            historico.add("Valor inválido");
        }
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da conta: " + numeroConta);
        System.out.println("Titular: " + titular);

        for (String operacao : historico) {
            System.out.println(operacao);
        }

        System.out.println("Saldo final: R$ " + saldo);
    }
}