package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        } else {
            System.out.println("Palavra nao encontrada");
        }
    }

    public void exibirPalavras() {
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra) {

        String palavraPesquisada = null;

        if (!dicionarioMap.isEmpty()) {
            palavraPesquisada = dicionarioMap.get(palavra);
        }
        return palavraPesquisada;
    }

    public static void main(String[] args) {

        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("tá na Disney", "está no mundo da lua, viajando ou que está sendo enganado");
        dicionario.adicionarPalavra("LOL", "rindo alto. é uma sigla para a expressão em inglês Laughing Out Loud");
        dicionario.adicionarPalavra("Perdi/Perdi foi tudo", "dizer que você está rindo muito de algo engraçado. O perdi foi tudo remete aos desafios de tente não rir, quando a pessoa não se aguenta e cai na gargalhada.");
        dicionario.adicionarPalavra("Flopar", "significa falhar, fracassar ou não ter sucesso. é o mesmo que falar que não deu certo ou não ocorreu como o esperado");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("Perdi/Perdi foi tudo");
        dicionario.exibirPalavras();

        System.out.println("O significado da palavra pesquisada é: " + dicionario.pesquisarPorPalavra("LOL"));

    }

}
