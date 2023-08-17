package map.Ordenacao;

import java.util.Comparator;
import java.util.Map;

public class Livro implements Comparable<Livro> {

    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public int compareTo(Livro l) {
        int comparaPreco = Double.compare(preco, l.getPreco());
        if (comparaPreco != 0) {
            return comparaPreco;
        }

        return titulo.compareTo(l.getTitulo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;

        if (Double.compare(getPreco(), livro.getPreco()) != 0) return false;
        if (!getTitulo().equals(livro.getTitulo())) return false;
        return getAutor().equals(livro.getAutor());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getTitulo().hashCode();
        result = 31 * result + getAutor().hashCode();
        temp = Double.doubleToLongBits(getPreco());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                '}';
    }

}

class ComparatorPorAutor implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getAutor().compareToIgnoreCase(l2.getValue().getAutor());
    }

}