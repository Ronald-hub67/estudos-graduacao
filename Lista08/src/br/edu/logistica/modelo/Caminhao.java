package br.edu.logistica.modelo;

public class Caminhao extends Veiculo implements Monitoravel{


    private int eixos;

    public Caminhao(String placa, double capacidadeCarga, StatusVeiculo status, TipoCombustivel tipoCombustivel, int eixos) {
        super(placa, capacidadeCarga, status, tipoCombustivel);
        this.eixos = eixos;
    }

    public int getEixos() { return eixos; }

    @Override
    public double calcularAutonomia() {
        double base = getTipoCombustivel().getFator() * 100;
        double penalidade = 1.0 - (0.05 * (eixos - 1));
        return base * penalidade;
    }
    @Override
    public void enviarCoordenadas() {
        System.out.println("Coordenadas enviadas via Satélite. Placa: " + getPlaca());
    }

    @Override
    public String obterLocalizacaoAtual() {
        return "Localização atual do veículo " + getPlaca() + ": Rodovia BR-116, km 342.";
    }
}
