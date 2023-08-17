package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {


    /**
     *
     * : Adiciona um convidado ao conjunto.
     * : Remove um convidado do conjunto com base no código do convite.
     * : Conta o número total de convidados no Set.
     * : Exibe todos os convidados do conjunto.
     */


    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {

        Convidado convidadoParaRemover = null;
        for (Convidado c : convidadoSet) {
            if (c.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = c;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        if (!convidadoSet.isEmpty()) {
            System.out.println(this.convidadoSet);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {

        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        System.out.println(conjuntoConvidados.contarConvidados() + " convidados");

        conjuntoConvidados.adicionarConvidado("Nome 1", 10);
        conjuntoConvidados.adicionarConvidado("Nome 2", 60);
        conjuntoConvidados.adicionarConvidado("Nome 3", 25);

        // ao adicionar equals and hashcode garantimos que os elementos nao sejam repetidos, por isso o resultado ira subtrair um dos convidados cujo codigo estiver repetido

        conjuntoConvidados.adicionarConvidado("Nome 1", 37);
        conjuntoConvidados.adicionarConvidado("Nome 5", 37);

        conjuntoConvidados.exibirConvidados();

        System.out.println(conjuntoConvidados.contarConvidados() + " convidados");

        conjuntoConvidados.removerConvidadoPorCodigoConvite(37);
        conjuntoConvidados.exibirConvidados();
        System.out.println(conjuntoConvidados.contarConvidados() + " convidados");

    }
}
