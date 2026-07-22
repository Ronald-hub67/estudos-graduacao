package teste;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        listaFuncionarios.add(new Gerente("ney", 9000, Departamento.FINANCEIRO, 2000));
        listaFuncionarios.add(new Gerente("giox", 5000, Departamento.RH, 1000));
        listaFuncionarios.add(new Vendedor("alex", 1500, Departamento.VENDAS, 500));
        listaFuncionarios.add(new Vendedor("cj", 1500, Departamento.VENDAS, 500));

        for (Funcionario f : listaFuncionarios) {
            System.out.println(f.getNome() +  " recebe " + f.calcularSalario());

            if (f instanceof Gerente) {
                Gerente g = (Gerente) f;
                System.out.println("Bônus do gerente: " + g.getBonus());
            }
        }
    }
}