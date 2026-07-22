package com.graduacao;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> acervo;
    public static int totalLivrosEmprestados = 0;

    public Biblioteca() {
        acervo = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    public void emprestarLivro(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {

                if (livro.isDisponivel()) {
                    livro.setDisponivel(false);
                    totalLivrosEmprestados++;
                    System.out.println("Livro emprestado com sucesso!");
                } else {
                    System.out.println("Livro indisponível.");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void devolverLivro(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {

                if (!livro.isDisponivel()) {
                    livro.setDisponivel(true);
                    totalLivrosEmprestados--;
                    System.out.println("Livro devolvido com sucesso!");
                } else {
                    System.out.println("Livro já está disponível.");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public ArrayList<Livro> buscarLivrosPorAutor(String autor) {
        ArrayList<Livro> resultado = new ArrayList<>();

        for (Livro livro : acervo) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public void buscarLivro(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void listarLivrosDisponiveis() {
        System.out.println("\nLivros Disponíveis:");

        boolean encontrou = false;

        for (Livro livro : acervo) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro disponível.");
        }
    }
}
