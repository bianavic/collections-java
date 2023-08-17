package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void  adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        if (!contatoSet.isEmpty()) {
            System.out.println(this.contatoSet);
        } else {
            System.out.println("A agenda está vazia!");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) {

        // cria Set vazio para agrupar os contatos por nome
        Set<Contato> contatosPorNome = new HashSet<>();

        for (Contato c : contatoSet) {
            if (c.getNome().startsWith(nome)) {
                // quero q contatosPorNome receba esses contatos que encontrados
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {

        Contato contatoAtualizado = null;

        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;

    }

    public static void main(String[] args) {

        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Ana", 123);
        agendaContatos.adicionarContato("Ana", 222); // nome igual nao sera adicionado à agenda (equals and hashCode)
        agendaContatos.adicionarContato("Ana Maria", 321);
        agendaContatos.adicionarContato("Alex", 456);
        agendaContatos.adicionarContato("Taty", 654);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Ana"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Alex", 111));
    }
}
