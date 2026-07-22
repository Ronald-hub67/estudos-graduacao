package software.modelo;

public enum Prioridade {
    BAIXA(72),
    MEDIA(48),
    ALTA(24),
    URGENTE(4);

    private final int prazoHoras;

    Prioridade(int prazoHoras) {
        this.prazoHoras = prazoHoras;
    }

    public int getPrazoHoras() {
        return prazoHoras;
    }
}