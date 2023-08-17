package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    private void adicionarPalavra(String palavra) {
        palavrasUnicasSet.add(palavra);
    }

    private void removerPalavra(String palavra) {
        if (!palavrasUnicasSet.isEmpty()) {
            palavrasUnicasSet.remove(palavra);
        } else {
            System.out.println("O conunto está vazio");
        }
    }

    private boolean verificarPalavra(String palavra) {
        return palavrasUnicasSet.contains(palavra);
    }

    private void exibirPalavrasUnicas() {}

    /**
     * : Adiciona uma palavra ao conjunto.
     * : Remove uma palavra do conjunto.
     * : Verifica se uma palavra está presente no conjunto.
     * : Exibe todas as palavras únicas do conjunto.
     */
}
