package Estudos;

public class Main {
    public static void main(String[] args){
        Celular celularA = new Celular();
        celularA.nome = "Iphone 12";
        celularA.tamanhoTela = 6.1f;
        celularA.espacoArmazenamento = 256;
        celularA.sistemaOperacional = "iOS";

        System.out.println("Celular: " + celularA.nome);
        System.out.println("Tela: " + celularA.tamanhoTela);
        System.out.println("Espaço: " + celularA.espacoArmazenamento);
        System.out.println("Sistema operacional: " + celularA.sistemaOperacional);
    }
}