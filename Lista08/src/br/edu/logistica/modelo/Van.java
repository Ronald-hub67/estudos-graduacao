package br.edu.logistica.modelo;

public class Van extends Veiculo {
    private boolean possuiRefrigeracao;

    public Van(String placa, double capacidadeCarga,
               StatusVeiculo status, TipoCombustivel tipoCombustivel,
               boolean possuiRefrigeracao) {
        super(placa, capacidadeCarga, status, tipoCombustivel);
        this.possuiRefrigeracao = possuiRefrigeracao;
    }

    public boolean isPossuiRefrigeracao() { return possuiRefrigeracao; }

    @Override
    public double calcularAutonomia() {
        double base = getTipoCombustivel().getFator() * 80;
        return possuiRefrigeracao ? base * 0.85 : base;
    }
}
