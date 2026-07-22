package br.edu.logistica.modelo;

public abstract class Veiculo {

    private String placa;
    private double capacidadeCarga;
    private StatusVeiculo status;
    private TipoCombustivel tipoCombustivel;

    public Veiculo(String placa, double capacidadeCarga, StatusVeiculo status, TipoCombustivel tipoCombustivel) {
        this.placa = placa;
        this.capacidadeCarga = capacidadeCarga;
        this.status = status;
        this.tipoCombustivel = tipoCombustivel;
    }

    public abstract double calcularAutonomia();

    public final String getPlaca() { return placa; }
    public final double getCapacidadeCarga() { return capacidadeCarga; }
    public final StatusVeiculo getStatus() { return status; }
    public final TipoCombustivel getTipoCombustivel() { return tipoCombustivel; }
    public final void setStatus(StatusVeiculo status) { this.status = status; }
}