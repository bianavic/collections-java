package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {

    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {

        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);

        if (!pessoaList.isEmpty()) {
            Collections.sort(pessoasPorIdade);
            return pessoasPorIdade;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }

    }

    public List<Pessoa> ordenarPorAltura() {

        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;

    }

    public static void main(String[] args) {

        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Nome 1", 10, 1.50);
        ordenacaoPessoas.adicionarPessoa("Nome 2", 30, 1.85);
        ordenacaoPessoas.adicionarPessoa("Nome 3", 45, 1.70);
        ordenacaoPessoas.adicionarPessoa("Nome 4", 19, 1.60);

        System.out.println(ordenacaoPessoas.pessoaList);
        System.out.println(ordenacaoPessoas.ordenarPorIdade());
        System.out.println(ordenacaoPessoas.ordenarPorAltura());

    }

}
