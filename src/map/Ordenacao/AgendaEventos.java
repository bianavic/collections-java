package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {

    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventoMap.put(data, new Evento(nome, atracao));
    }

    // o localdate ja sabe como organizar as datas, ele implementa um Comparable<ChronoLocalDate>
    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {

        /**
        // os metodos abaixo nao se relacionam. vc consegue obter OU as keys OU os valores
        Set<LocalDate> dateSet = eventoMap.keySet(); // metodo 1: retorna set com todas as chaves
        Collection<Evento> values = eventoMap.values(); // metodo 2: retorna uma colecao com todos os valores
        eventoMap.get(); // este metodo só funciona se eu souber qual a chave
         *
         *
         * ODS: java mais recente posso escrever a linha 41 utilizando var
         * (var entry : eventoMap.entrySet())
         **/

        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;

        // reutilizo o map que ja contem eventos organizados na ordem crescente
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);

        for (Map.Entry<LocalDate, Evento> entry : eventoMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
            }
        }
    }

    public static void main(String[] args) {

        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 17), "Evento 1", "Atracao 1");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.NOVEMBER, 23), "Evento 2", "Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2037, Month.APRIL, 05), "Evento 3", "Atracao 3");
        agendaEventos.adicionarEvento(LocalDate.of(1986, Month.JULY, 04), "Evento 4", "Atracao 4");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }

}
