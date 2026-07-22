import java.nio.file.*;
import java.util.*;

interface Persistencia {
    void salvar(List<Contato> contatos) throws Exception;
    List<Contato> carregar() throws Exception;
}

class AgendaArquivo implements Persistencia {
    private final Path arquivo = Paths.get("contatos.txt");

    @Override
    public void salvar(List<Contato> contatos) throws Exception {
        List<String> linhas = new ArrayList<>();

        for (Contato c : contatos) {
            String extra = "";
            if (c instanceof Cliente) {
                extra = ((Cliente) c).getEmpresa();
            } else if (c instanceof Fornecedor) {
                extra = ((Fornecedor) c).getServico();
            }

            linhas.add(c.getTipo() + ";" + c.getNome() + ";" + c.getEmail() + ";" + extra);
        }

        Files.write(arquivo, linhas,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING); // evita duplicacao antes de salva
    }

    @Override
    public List<Contato> carregar() throws Exception {
        List<Contato> contatos = new ArrayList<>();

        List<String> linhas = Files.readAllLines(arquivo);
        for (String linha : linhas) {
            String[] partes = linha.split(";");
            if (partes.length < 4) continue;

            String tipo = partes[0];
            String nome = partes[1];
            String email = partes[2];
            String extra = partes[3];

            if (tipo.equals(TipoContato.CLIENTE.name())) {
                contatos.add(new Cliente(nome, email, extra));
            } else if (tipo.equals(TipoContato.FORNECEDOR.name())) {
                contatos.add(new Fornecedor(nome, email, extra));
            }
        }
        return contatos;
    }
}