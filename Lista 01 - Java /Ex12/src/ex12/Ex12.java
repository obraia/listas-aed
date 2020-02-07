package ex12;

import java.util.ArrayList;

/**
 * @author bryan
 */
class Aluno {

    private int Numero;
    private char[] Respostas;
    private int Nota;

    public Aluno(int numero, char[] respostas) {
        this.Numero = numero;
        this.Respostas = respostas;
    }
    
    public int getNumero() { return this.Numero; }
    public int getNota() { return this.Nota; }
    
    public void VerificarRespostas(char[] gabarito) {

        for (int i = 0; i < this.Respostas.length; i++) {

            if (gabarito[i] == this.Respostas[i]) {
                this.Nota++;
            }
        }
    }
}

public class Ex12 {

    public static void main(String[] args) {

        char[] gabarito = {'A', 'C', 'E', 'B', 'A', 'D', 'C', 'A'};

        int quantAprovados = 0;
        double porcentAprovados;

        // --> Criar lista do tipo Aluno e adicionar alunos
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno(05, new char[]{'B', 'C', 'E', 'B', 'A', 'D', 'C', 'A'}));
        alunos.add(new Aluno(10, new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'}));
        alunos.add(new Aluno(15, new char[]{'A', 'B', 'B', 'B', 'A', 'D', 'C', 'A'}));
        alunos.add(new Aluno(20, new char[]{'A', 'C', 'B', 'B', 'A', 'C', 'A', 'B'}));
        alunos.add(new Aluno(25, new char[]{'C', 'C', 'E', 'B', 'A', 'D', 'E', 'B'}));
        alunos.add(new Aluno(30, new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'}));
        alunos.add(new Aluno(35, new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'}));
        alunos.add(new Aluno(40, new char[]{'A', 'C', 'E', 'B', 'A', 'D', 'C', 'A'}));
        alunos.add(new Aluno(45, new char[]{'A', 'A', 'C', 'B', 'A', 'D', 'C', 'E'}));
        alunos.add(new Aluno(50, new char[]{'B', 'A', 'E', 'B', 'A', 'D', 'C', 'A'}));

        // --> Verificar respostas, aplicar notas aos alunos e fazer contagem de aprovados
        for (int i = 0; i < alunos.size(); i++) {

            alunos.get(i).VerificarRespostas(gabarito);

            if (alunos.get(i).getNota() >= 5) {
                quantAprovados++;
            }
        }

        // --> Informar notas e números dos alunos
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(String.format("Aluno: %d - Nota: %d", alunos.get(i).getNumero(), alunos.get(i).getNota()));
        }

        porcentAprovados = (((double) quantAprovados / alunos.size()) * 100);

        System.out.println(String.format("\nA porcentagem de alunos aprovados é %.2f %% \n", porcentAprovados));
    }
}
