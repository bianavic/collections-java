package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livrosList;

    public CatalogoLivros() {
        this.livrosList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CatalogoLivros{" +
                "livrosList=" + livrosList +
                '}';
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livrosList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {

        List<Livro> livrosPorAutor = new ArrayList<>();

        if (!livrosList.isEmpty()) {
            for (Livro l : livrosList) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
            return livrosPorAutor;
        } else {
            throw new RuntimeException("A lista está vazia");
        }

    }

    public List<Livro> pesquisarPorTitulo(String titulo) {

        List<Livro> livrosPorTitulo = new ArrayList<>();

        if (!livrosList.isEmpty()) {
            for (Livro l : livrosList) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    livrosPorTitulo.add(l);
                }
            }
            return livrosPorTitulo;
        } else {
            throw new RuntimeException("A lista está vazia");
        }

    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {

        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();

        if (!livrosList.isEmpty()) {
            for (Livro l : livrosList) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosPorIntervaloAnos.add(l);
                }
            }
            return livrosPorIntervaloAnos;
        } else {
            throw new RuntimeException("A lista está vazia");
        }

    }

    public static void main(String[] args) {

        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Entendendo Algoritmos", "Aditya Y. Bhargava", 2017);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("Domain-Driven Design", "Eric Evans", 2016);

        System.out.println(catalogoLivros.pesquisarPorAutor("Eric Evans"));

        System.out.println(catalogoLivros.pesquisarPorTitulo("Entendendo Algoritmos"));

        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2015, 2016));
    }

}
