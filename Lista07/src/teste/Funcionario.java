package teste;

enum Departamento {
    VENDAS, FINANCEIRO, RH;
}

class Funcionario {
    private String nome;
    private double salarioBase;
    private Departamento departamento;

    public Funcionario(String nome, double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.setSalarioBase(salarioBase);
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) {
            this.salarioBase = salarioBase;
        } else {
            System.out.println("Erro: Salário não pode ser negativo.");
        }
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public double calcularSalario() {
        return salarioBase;
    }
}

class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, double salarioBase, Departamento departamento, double bonus) {
        super(nome, salarioBase, departamento);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonus;
    }
}

class Vendedor extends Funcionario {
    private double comissao;

    public Vendedor(String nome, double salarioBase, Departamento departamento, double comissao) {
        super(nome, salarioBase, departamento);
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + comissao;
    }
}
