package software.main;

import software.gestao.GerenciadorTickets;
import software.modelo.Prioridade;
import software.modelo.Ticket;

public class SistemaPrincipal {
    public static void main(String[] args) {
        GerenciadorTickets gerenciador = new GerenciadorTickets();

        gerenciador.adicionarTicket(new Ticket("Erro no login", Prioridade.URGENTE));
        gerenciador.adicionarTicket(new Ticket("Ajuste de cor no rodapé", Prioridade.BAIXA));
        gerenciador.adicionarTicket(new Ticket("Banco de dados lento", Prioridade.ALTA));
        gerenciador.adicionarTicket(new Ticket("Dúvida no manual", Prioridade.MEDIA));
        gerenciador.adicionarTicket(new Ticket("Relatório travando", Prioridade.URGENTE));

        System.out.println("--- Lista de Tickets (Ordenados por Urgência) ---");
        for (Ticket t : gerenciador.listarTodos()) {
            System.out.println(t.exibirDetalhes());
        }

        System.out.println("\nRemovendo Ticket ID 2...");
        gerenciador.removerTicket(2);

        System.out.println("Total de tickets ativos: " + gerenciador.contarTotal());
    }
}