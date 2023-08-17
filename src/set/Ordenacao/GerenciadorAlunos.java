package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {

        Aluno alunoParaRemover = null;

        if (!alunoSet.isEmpty()) {
            for (Aluno a : alunoSet) {
                if (a.getMatricula().equals(matricula)) {
                    alunoParaRemover = a;
                    break;
                }
            }
            alunoSet.remove(alunoParaRemover);
        } else {
            System.out.println("Matrícula não encontrada");
        }
    }

    private void exibirAlunos() {
        if (!alunoSet.isEmpty()) {
            System.out.println(alunoSet);
        } else {
            System.out.println("Não existem alunos cadastrados");
        }
    }

    private void exibirAlunosPorNome() {

        Set<Aluno> alunoPorNome = new TreeSet<>(alunoSet);

        if (!alunoSet.isEmpty()) {
            System.out.println(alunoPorNome);
        } else {
            throw new RuntimeException("Nome não encontrado");
        }
    }

    private void exibirAlunosPorNota() {

        Set<Aluno> alunoPorNota = new TreeSet<>(new ComparatorPorNota());

        if (!alunoSet.isEmpty()) {
            alunoPorNota.addAll(alunoSet);
            System.out.println(alunoPorNota);
        } else {
            System.out.println("Nota não encontrada");
        }
    }

    public static void main(String[] args) {

        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Augusto", 1L, 7.5d);
        gerenciadorAlunos.adicionarAluno("Ana", 2L, 9.5d);
        gerenciadorAlunos.adicionarAluno("Joao", 3L, 3d);
        gerenciadorAlunos.adicionarAluno("Antonio", 4L, 10d);

        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.exibirAlunosPorNome();

        gerenciadorAlunos.removerAluno(2L);

        gerenciadorAlunos.exibirAlunosPorNota();
    }

}
