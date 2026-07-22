public class Conta {
    int numero;
    String nomeTitular;
    double saldo;

    public Conta(){
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    void depositar(double valor){
        this.saldo = this.saldo + valor;
    }

    boolean sacar(double valor){
        if(this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            return true;
        } else {
            return false;
        }
    }
}
