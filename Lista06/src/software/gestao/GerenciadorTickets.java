package software.gestao;

import software.modelo.Prioridade;
import software.modelo.Ticket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenciadorTickets {
    private List<Ticket> listaTickets = new ArrayList<>();

    public void adicionarTicket(Ticket t) {
        listaTickets.add(t);
    }

    public void removerTicket(int id) {
        listaTickets.removeIf(t -> t.getId() == id);//id = parametro
    }

    public List<Ticket> listarTodos() {
        Collections.sort(listaTickets);
        return listaTickets;
    }

    public List<Ticket> listarPorPrioridade(Prioridade p) {
        List<Ticket> filtrados = new ArrayList<>();
        for (Ticket t : listaTickets) {
            if (t.getPrioridade() == p) {
                filtrados.add(t);
            }
        }
        return filtrados;
    }

    public int contarTotal() {
        return listaTickets.size();
    }
}
