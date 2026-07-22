public enum TipoContato {
    CLIENTE, FORNECEDOR
}

class Cliente extends Contato {
    private String empresa;

    public Cliente(String nome, String email, String empresa) {
        super(nome, email);
        this.empresa = empresa;
    }

    public String getEmpresa() { return empresa; }

    public void setEmpresa(String empresa) { this.empresa = empresa; }

    @Override
    public String getTipo() {
        return TipoContato.CLIENTE.name();
    }

    @Override
    public String toString() {
        return "[Cliente] Nome: " + getNome() + " | Email: " + getEmail() + " | Empresa: " + empresa;
    }
}

class Fornecedor extends Contato {
    private String servico;

    public Fornecedor(String nome, String email, String servico) {
        super(nome, email);
        this.servico = servico;
    }

    public String getServico() { return servico; }

    public void setServico(String servico) { this.servico = servico; }

    @Override
    public String getTipo() {
        return TipoContato.FORNECEDOR.name();
    }

    @Override
    public String toString() {
        return "[Fornecedor] Nome: " + getNome() + " | Email: " + getEmail() + " | Serviço: " + servico;
    }
}