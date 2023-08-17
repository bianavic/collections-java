package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> palavrasMap;

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        palavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!palavrasMap.isEmpty()) {
            palavrasMap.remove(palavra);
        } else {
            System.out.println("Palavra não encontrada ou inexistente");
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(palavrasMap);
    }

    public String encontrarPalavraMaisFrequente() {

        String palavraMaisFrequente = null;
        int maiorContagem = 0;

        for (Map.Entry<String, Integer> entry : palavrasMap.entrySet()) {
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {

        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("alegria", 1);
        contagemPalavras.adicionarPalavra("churrasco", 5);
        contagemPalavras.adicionarPalavra("beleza", 7);
        contagemPalavras.adicionarPalavra("vermelho", 2);

        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.removerPalavra("churrasco");
        System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente());
    }

}
