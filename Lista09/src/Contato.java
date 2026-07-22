public abstract class Contato implements Comparable<Contato> {

    private String nome;
    private String email;

    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getTipo();

    @Override
    public int compareTo(Contato outro) {
        if (this.nome == null || outro.getNome() == null) {
            return 0;
        }
        return this.nome.compareToIgnoreCase(outro.getNome());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Contato contato = (Contato) obj; //cast, vai transformar obj em Contato

        if (email == null) {
            return contato.email == null;
        } else {
            return email.equalsIgnoreCase(contato.email);
        }
    }
}