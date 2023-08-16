package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {

        List<Item> itemParaRemover = new ArrayList<>();

        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itemParaRemover.add(i);
                }
            }
            itemList.removeAll(itemParaRemover);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public double calcularValorTotal() {

        double valorTotal = 0d;

        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia");
        }

    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(itemList);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {

        CarrinhoDeCompras carrinhoDeCompra = new CarrinhoDeCompras();

        carrinhoDeCompra.adicionarItem("Livro", 50d, 2);
        carrinhoDeCompra.adicionarItem("Livro", 75d, 3);
        carrinhoDeCompra.adicionarItem("Kindle", 300d, 1);
        carrinhoDeCompra.adicionarItem("IPad", 2000.99, 1);

        carrinhoDeCompra.exibirItens();

        carrinhoDeCompra.removerItem("Ipad");
        carrinhoDeCompra.exibirItens();

        System.out.println("O valor total do carrinho é " + carrinhoDeCompra.calcularValorTotal());
    }

}
