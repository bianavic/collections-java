package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        // OBS: metodo PUT atualiza e insere
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        } else {
            System.out.println("Nome não encontrado");
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {

        Integer numeroPorNome = null;

        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {

        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos(); // o map devolve CHAVES {} qdo esta vazio

        agendaContatos.adicionarContato("Ana", 123);
        agendaContatos.adicionarContato("Ana", 456);
        agendaContatos.adicionarContato("Alice", 6789);
        agendaContatos.adicionarContato("Rodrigo", 101010);
        agendaContatos.adicionarContato("Jose Antonio", 8888);
        agendaContatos.adicionarContato("Jose Roberto", 101010);
        agendaContatos.adicionarContato("Ana", 999);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Jose Antonio");
        agendaContatos.exibirContatos();

        System.out.println("O telefone é: " + agendaContatos.pesquisarPorNome("Ana"));
    }
}
