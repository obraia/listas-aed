package ex12;

import java.util.ArrayList;

/**
 * @author bryan
 */

class Aluno {

    int Numero;
    char[] Respostas;
    int Nota;

    public Aluno(int numero, char[] respostas) {
        Numero = numero;
        Respostas = respostas;
    }
}

public class Ex12 {

    public static void main(String[] args) {

        char[] gabarito = {'A', 'C', 'E', 'B', 'A', 'D', 'C', 'A'};

        int quantAprovados = 0;
        double porcentAprovados;

        // --> Criando vetor do tipo Aluno e adicionando alunos
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

        // --> Verificando respostas e aplicando notas aos alunos e fazendo contagem de aprovados
        for (int i = 0; i < alunos.size(); i++) {

            for (int j = 0; j < alunos.get(i).Respostas.length; j++) {

                if (gabarito[j] == alunos.get(i).Respostas[j]) {
                    alunos.get(i).Nota++;
                }
            }

            if (alunos.get(i).Nota >= 5) {
                quantAprovados++;
            }
        }

        // --> Informando notas e números dos alunos
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(String.format("Aluno: %d - Nota: %d", alunos.get(i).Numero, alunos.get(i).Nota));
        }

        porcentAprovados = (((double) quantAprovados / 100) * alunos.size() * 100);

        System.out.println(String.format("\nA porcentagem de alunos aprovados é %.2f %%", porcentAprovados));

    }
}
