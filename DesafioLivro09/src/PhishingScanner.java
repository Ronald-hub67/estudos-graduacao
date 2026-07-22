import java.nio.file.*;
import java.util.*;

public class PhishingScanner {

    private static final Map<String, Integer> dicionarioGolpes = new HashMap<>();

    static {
        dicionarioGolpes.put("urgente", 3);
        dicionarioGolpes.put("conta bloqueada", 3);
        dicionarioGolpes.put("senha expirada", 3);
        dicionarioGolpes.put("suspensão imediata", 3);
        dicionarioGolpes.put("previdência social", 3);
        dicionarioGolpes.put("confirmar dados", 3);
        dicionarioGolpes.put("atividade suspeita", 3);
        dicionarioGolpes.put("recadastramento obrigatório", 3);
        dicionarioGolpes.put("herança", 3);
        dicionarioGolpes.put("ganhou um prêmio", 3);

        dicionarioGolpes.put("clique aqui", 2);
        dicionarioGolpes.put("verificar agora", 2);
        dicionarioGolpes.put("atualização cadastral", 2);
        dicionarioGolpes.put("vencimento hoje", 2);
        dicionarioGolpes.put("notificação judicial", 2);
        dicionarioGolpes.put("benefício liberado", 2);
        dicionarioGolpes.put("acesso negado", 2);
        dicionarioGolpes.put("segurança da conta", 2);
        dicionarioGolpes.put("recuperar acesso", 2);
        dicionarioGolpes.put("reembolso disponível", 2);

        dicionarioGolpes.put("paypal", 1);
        dicionarioGolpes.put("netflix", 1);
        dicionarioGolpes.put("amazon", 1);
        dicionarioGolpes.put("banco", 1);
        dicionarioGolpes.put("receita federal", 1);
        dicionarioGolpes.put("fatura", 1);
        dicionarioGolpes.put("suporte técnico", 1);
        dicionarioGolpes.put("administrador", 1);
        dicionarioGolpes.put("promoção", 1);
        dicionarioGolpes.put("cartão de crédito", 1);
    }

    public static void analisarArquivo(String caminhoArquivo) {
        int pontosTotaisMensagem = 0;

        try {
            String conteudo = Files.readString(Paths.get(caminhoArquivo)).toLowerCase();

            System.out.println("\n============================================================");
            System.out.println("        RELATÓRIO DE ANÁLISE DE PHISHING (HEURÍSTICA)       ");
            System.out.println("============================================================");
            System.out.printf("%-25s | %-10s | %-10s%n", "TERMO IDENTIFICADO", "OCORRÊNCIAS", "SUBTOTAL");
            System.out.println("------------------------------------------------------------");

            for (Map.Entry<String, Integer> entrada : dicionarioGolpes.entrySet()) {
                String termo = entrada.getKey();
                int peso = entrada.getValue();

                int ocorrencias = contarTermo(conteudo, termo);

                if (ocorrencias > 0) {
                    int subtotal = ocorrencias * peso;
                    pontosTotaisMensagem += subtotal;
                    System.out.printf("%-25s | %-11d | %-10d%n", termo, ocorrencias, subtotal);
                }
            }

            System.out.println("------------------------------------------------------------");
            System.out.println("PONTUAÇÃO TOTAL DE RISCO: " + pontosTotaisMensagem);

            // Critério de avaliação
            if (pontosTotaisMensagem >= 15) {
                System.out.println("STATUS: [ALTÍSSIMO RISCO] Esta mensagem é provavelmente um GOLPE.");
            } else if (pontosTotaisMensagem >= 5) {
                System.out.println("STATUS: [ATENÇÃO] Mensagem suspeita. Verifique o remetente.");
            } else {
                System.out.println("STATUS: [SEGURO] Baixa probabilidade de phishing.");
            }
            System.out.println("============================================================\n");

        } catch (NoSuchFileException e) {
            System.out.println("Erro: O arquivo '" + caminhoArquivo + "' não foi encontrado.");
        } catch (Exception e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
        }
    }

    private static int contarTermo(String texto, String termo) {
        int count = 0;
        int index = 0;
        while ((index = texto.indexOf(termo, index)) != -1) {
            count++;
            index += termo.length();
        }
        return count;
    }

    public static void main(String[] args) {
        analisarArquivo("email_teste.txt");
    }
}