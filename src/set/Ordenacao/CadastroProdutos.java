package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {

        // utilizaremos TreeSet pois ele é capaz de organizar, dentro dele vou passar a colecao (produtoSet)
        // a organizacao acontecera pq implementamos comparable indicando q a ordem natural será por nome
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);

        if (!produtoSet.isEmpty()) {
            return produtosPorNome;
        } else {
            throw new RuntimeException("Não existem produtos com esse nome");
        }

    }

    public Set<Produto> exibirProdutosPorPreco() {

        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());

        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {

        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Produto 1", 10d, 2);
        cadastroProdutos.adicionarProduto(1L, "Produto 2", 60d, 2);
        cadastroProdutos.adicionarProduto(2L, "Produto 5", 50d, 5);
        cadastroProdutos.adicionarProduto(10L, "Produto 0", 1d, 10);
        cadastroProdutos.adicionarProduto(9L, "Produto 11", 990d, 2);

        System.out.println(cadastroProdutos.produtoSet);

        System.out.println("Ordenação produtos por Nome: " + cadastroProdutos.exibirProdutosPorNome());
        System.out.println("Ordenação produtos Pelo Preço: " + cadastroProdutos.exibirProdutosPorPreco());
    }

}
