package com.example;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Alguns instâncias das classes desenvolvidas

        Professor joao = new Professor("Joao");

        Aluno artur = new Aluno("Artur");
        Aluno davi = new Aluno("Davi");

        Disciplina map = new Disciplina("MAP");
        Disciplina leda = new Disciplina("LEDA");

        Horario horario01 = new Horario("Segunda", LocalTime.of(7, 0), LocalTime.of(9, 0));
        Horario horario02 = new Horario("Segunda", LocalTime.of(9, 0), LocalTime.of(11, 0));

        map.setHorarios(horario01);
        map.setHorarios(horario02);

        artur.setDisciplinas(map);
        artur.setDisciplinas(leda);
        davi.setDisciplinas(leda);

        joao.setDisciplinas(map);
        joao.setDisciplinas(leda);

        System.out.println(joao.verDisciplinas());
        System.out.println(joao.verHorarios());

        System.out.println(map.verAlunos());
        System.out.println(leda.verAlunos());

        System.out.println(artur.verDisciplinas());
        System.out.println(artur.verHorarios());

        System.out.println(leda.numeroAlunos());
    }
}