public class MainEncapsulamento {
    public static void main(String[] args){
        Produto p = new Produto();

        p.setEstoque(10);
        p.setNome("TV");

        String nomeProduto = p.getNome();
        int qtd = p.getEstoque();

        System.out.println(nomeProduto);
        System.out.println(qtd);

        p.setEstoque(p.getEstoque() - 1 );
        System.out.println("Novo estq " + p.getEstoque());
    }
}