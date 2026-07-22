package br.edu.logistica.servico;

import br.edu.logistica.modelo.StatusVeiculo;
import br.edu.logistica.modelo.Veiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorFrota {

    private List<Veiculo> frota;
    private Map<String, Veiculo> indicePorPlaca;

    public GerenciadorFrota() {
        this.frota = new ArrayList<>();
        this.indicePorPlaca = new HashMap<>();
    }

    public final void adicionarVeiculo(Veiculo v) {
        frota.add(v);
        indicePorPlaca.put(v.getPlaca(), v);
        System.out.println("Veículo adicionado: " + v.getPlaca());
    }

    public final void listarVeiculosDisponiveis() {
        System.out.println("\n--- Veículos Disponíveis ---");
        boolean encontrou = false;

        for (Veiculo v : frota) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                System.out.println("Placa: " + v.getPlaca()
                        + " | Capacidade: " + v.getCapacidadeCarga() + "t"
                        + " | Combustível: " + v.getTipoCombustivel());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum veículo disponível no momento.");
        }
    }

    public final void gerarRelatorioAutonomia() {
        System.out.println("\n--- Relatório de Autonomia ---");

        for (Veiculo v : frota) {
            System.out.printf("Placa: %-10s | Autonomia: %.1f km%n",
                    v.getPlaca(), v.calcularAutonomia());
        }
    }

    public final Veiculo buscarPorPlaca(String placa) {
        return indicePorPlaca.get(placa);
    }
}