package software.modelo;

public class Ticket implements Comparable<Ticket> {
    private final int id;
    private String descricao;
    private Prioridade prioridade;

    private static int contador = 1;
    public static final String NOME_SISTEMA = "SISTEMA_SUPORTE_V1";

    public Ticket(String descricao, Prioridade prioridade) {
        this.id = contador++;
        setDescricao(descricao);
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.trim().isEmpty()) {
            this.descricao = descricao;
        } else {
            this.descricao = "Sem descrição";
        }
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String exibirDetalhes() {
        return String.format("[%s] ID: %d | Descrição: %s | Prioridade: %s | Prazo: %dh", NOME_SISTEMA, id, descricao, prioridade, prioridade.getPrazoHoras());
    }

    @Override
    public int compareTo(Ticket outro) {
        return outro.prioridade.ordinal() - this.prioridade.ordinal(); //ordem do enum
    }
}