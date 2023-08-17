package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefaSet.add(tarefa);
    }

    public void removerTarefa(String descricao) {

        Tarefa tarefaParaRemover = null;

        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto está vazio");
        }

        if (tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada");
        }

    }

    public void exibirTarefas() {
        if (!tarefaSet.isEmpty()) {
            System.out.println(tarefaSet);
        } else {
            System.out.println("Não existem tarefas para exibir");
        }
    }

    public int contarTarefas() {
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {

        Set<Tarefa> tarefasConcluidas = new HashSet<>();

            for (Tarefa t : tarefaSet) {
                if (t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {

        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for (Tarefa t : tarefaSet) {
            if (!t.isConcluida()) {
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa t : tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(true);
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {

        Tarefa tarefaParaMarcarComoPendente = null;

        for (Tarefa t : tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaMarcarComoPendente = t;
            }
        }

        if (tarefaParaMarcarComoPendente != null) {
            tarefaParaMarcarComoPendente.setConcluida(false);
            System.out.println("Tarefa para marcar como Pendente: " + tarefaParaMarcarComoPendente.getDescricao());
        } else {
            System.out.println("Tarefa não encontrada na lista");
        }
    }

    public void limparListaTarefas() {
        if (!tarefaSet.isEmpty()) {
            tarefaSet.clear();
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {

        ListaTarefas listaTarefas = new ListaTarefas();

        System.out.println("Contem " + listaTarefas.contarTarefas() + " tarefas");

        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 1", false));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 2", false));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 3", false));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 4", false));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 5", true));

        listaTarefas.exibirTarefas();
        System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());
        System.out.println("Contem " + listaTarefas.contarTarefas() + " tarefas");

        listaTarefas.removerTarefa("Tarefa 1");
        listaTarefas.exibirTarefas();
        System.out.println("Contem " + listaTarefas.contarTarefas() + " tarefas");

        System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
        System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaConcluida("Tarefa 2");
        listaTarefas.exibirTarefas();
        System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());

        listaTarefas.marcarTarefaPendente("Tarefa 5");
        System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());

        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();

    }

}
