import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class MainArrayList {
    public static void main(String[] args) {
        SortedSet<Aluno> alunos = new TreeSet<>();
        alunos.add(new Aluno(1111, "João Costa", 20));
        alunos.add(new Aluno(1112, "Maria Rita", 21));
        alunos.add(new Aluno(1113, "José de Castro", 22));
        alunos.add(new Aluno(1114, "Ricardo Caetano", 20));
        alunos.add(new Aluno(1115, "Maria Rita", 23));

        for (Aluno aluno : alunos) {

            System.out.println("Nome: " + aluno.getNome()
                    + ". Matrícula: " + aluno.getMatricula());
        }
    }
}