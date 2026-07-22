import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        Conta c = new Conta();

        System.out.println("Informe o nome do Titular: ");
        c.nomeTitular = leitor.nextLine();
        System.out.println("Informe o numero da conta: ");
        c.numero = leitor.nextInt();
        System.out.println("Informe o saldo: ");
        c.saldo = leitor.nextDouble();

        c.depositar(20);
        boolean saque = c.sacar(50);

        if(saque)
            System.out.println("Saque Efetuado!");
        else
            System.out.println("Saldo insuficiente.");

        System.out.println("Saldo Atual: " + c.saldo);
    }
}