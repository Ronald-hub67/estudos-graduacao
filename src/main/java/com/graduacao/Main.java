package com.graduacao;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int op;

        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Emprestar livro");
            System.out.println("3 - Devolver livro");
            System.out.println("4 - Buscar livro por título");
            System.out.println("5 - Buscar livros por autor");
            System.out.println("6 - Listar livros disponíveis");
            System.out.println("7 - Mostrar total de livros emprestados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    biblioteca.adicionarLivro(new Livro(titulo, autor));
                    break;
                case 2:
                    System.out.print("Título para empréstimo: ");
                    String tituloEmprestar = sc.nextLine();
                    biblioteca.emprestarLivro(tituloEmprestar);
                    break;
                case 3:
                    System.out.print("Título para devolução: ");
                    String tituloDevolver = sc.nextLine();
                    biblioteca.devolverLivro(tituloDevolver);
                    break;
                case 4:
                    System.out.print("Título para busca: ");
                    String tituloBuscar = sc.nextLine();
                    biblioteca.buscarLivro(tituloBuscar);
                    break;
                case 5:
                    System.out.print("Autor para busca: ");
                    String autorBuscar = sc.nextLine();

                    ArrayList<Livro> livrosAutor = biblioteca.buscarLivrosPorAutor(autorBuscar);

                    if (livrosAutor.isEmpty()) {
                        System.out.println("Nenhum livro encontrado para este autor.");
                    } else {
                        System.out.println("Livros encontrados:");
                        for (Livro livro : livrosAutor) {
                            System.out.println(livro);
                        }
                    }
                    break;
                case 6:
                    biblioteca.listarLivrosDisponiveis();
                    break;
                case 7:
                    System.out.println("Total de livros emprestados: "
                            + Biblioteca.totalLivrosEmprestados);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 0);

        sc.close();
    }
}