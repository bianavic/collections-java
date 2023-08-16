package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        // criar com arraylist vazio
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        /**
         * verificar se elementos possuem a mesma descricao
         * para isso, criar a lista
         * entao iterar para encontrar itens com mesma descricao
         */
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t : tarefaList) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(t);
            }
        }
        // remova aquelas tarefas encontradas na iteracao
        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    // é void pq quer apenas obter a lista
    public void obterDescricoesTarefas() {
        System.out.println(tarefaList);
    }

    // testar
    public static void main(String[] args) {

        ListaTarefa listaTarefa = new ListaTarefa();
        System.out.println("Numero total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        listaTarefa.adicionarTarefa("Tarefa 2");
        listaTarefa.adicionarTarefa("Tarefa 3");
        System.out.println("Numero total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("Tarefa 3");
        System.out.println("Numero total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricoesTarefas();

    }

}
