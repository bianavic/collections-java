package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        if (!estoqueProdutosMap.isEmpty()) {
            System.out.println(estoqueProdutosMap);
        } else {
            System.out.println("Estoque vazio");
        }
    }

    public double calcularValorTotalEstoque() {

        // variavel para armazenar o valor total
        double valorTotal = 0d;

        if (!estoqueProdutosMap.isEmpty()) {
            // laco de repeticao só preciso dos valores
            for (Produto p : estoqueProdutosMap.values()) {
                valorTotal += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotal;

    }

    public Produto obterProdutoMaisCaro() {

        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
            return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {

        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        for (Produto p : estoqueProdutosMap.values()) {
            if (p.getPreco() < menorPreco) {
                produtoMaisBarato = p;
                menorPreco = p.getPreco();
            }
        }
        return produtoMaisBarato;
    }

    public double obterProdutoMaiorQuantidade() {

        int produtoComMaiorQtdade = 0;
        for (Produto p : estoqueProdutosMap.values()) {
            produtoComMaiorQtdade = p.getQuantidade();
        }
        return produtoComMaiorQtdade;

    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorNoEstoque = null;
        double maiorValorTotalProdutoNoEstoque = 0d;

        if (!estoqueProdutosMap.isEmpty()) {

            for (Map.Entry<Long, Produto> entry : estoqueProdutosMap.entrySet()) {
                double valorProdutoEmEsqtoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if (valorProdutoEmEsqtoque > maiorValorTotalProdutoNoEstoque) {
                    maiorValorTotalProdutoNoEstoque = valorProdutoEmEsqtoque;
                    produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
                }
            }
        }
        return produtoMaiorQuantidadeValorNoEstoque;
    }

    public static void main(String[] args) {

        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Produto 1", 3, 10d);
        estoqueProdutos.adicionarProduto(22L, "Produto 2", 2, 1000d);
        estoqueProdutos.adicionarProduto(3L, "Produto 3", 10, 100d);
        estoqueProdutos.adicionarProduto(45L, "Produto 4", 50, 20d);

        estoqueProdutos.exibirProdutos();

        System.out.println("O valor total é : R$" + estoqueProdutos.calcularValorTotalEstoque());

        System.out.println("O produto com maior preço é: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("O produto com menor preço é: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("O produto com maior quantidade é: " + estoqueProdutos.obterProdutoMaiorQuantidade() + " unidades");

        System.out.println("O estoque mais caro é do produto: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());

    }

}
