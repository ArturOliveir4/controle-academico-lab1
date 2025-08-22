package expert.application;

import java.time.LocalTime;

import expert.model.entities.Aluno;
import expert.model.entities.Disciplina;
import expert.model.entities.Horario;
import expert.model.entities.Professor;
import expert.model.services.ControleAcademicoService;

public class Program {
    public static void main(String[] args) {

        Professor sabrina = new Professor("Sabrina");
        Professor dunfray = new Professor("Dunfray");

        Aluno artur = new Aluno("Artur");
        Aluno davi = new Aluno("Davi");

        Horario horario1 = new Horario("Segunda", LocalTime.of(7, 0), LocalTime.of(9, 0));
        Horario horario2 = new Horario("Segunda", LocalTime.of(9, 0), LocalTime.of(11, 0));
        Horario horario3 = new Horario("Segunda", LocalTime.of(11, 0), LocalTime.of(13, 0));
        Horario horario4 = new Horario("Terça", LocalTime.of(9, 0), LocalTime.of(11, 0));
        Horario horario5 = new Horario("Terça", LocalTime.of(11, 0), LocalTime.of(13, 0));
        Horario horario6 = new Horario("Quarta", LocalTime.of(7, 0), LocalTime.of(9, 0));
        Horario horario7 = new Horario("Quarta", LocalTime.of(11, 0), LocalTime.of(13, 0));

        Disciplina map = new Disciplina("Métodos Avançados de Programação", horario1);
        Disciplina edsw = new Disciplina("Engenharia de Software", horario2);
        Disciplina redes = new Disciplina("Redes de Computadores", horario3);
        Disciplina prob = new Disciplina("Probabilidade e Estatística II", horario4);
        Disciplina bd = new Disciplina("Banco de Dados", horario5);
        Disciplina paradigmas = new Disciplina("Paradigmas de Programação", horario6);
        Disciplina taal = new Disciplina("Técnica e Análise de Algoritmos", horario7);

        ControleAcademicoService controle = new ControleAcademicoService();

        controle.matricularAluno(davi, map);
        controle.matricularAluno(davi, edsw);
        controle.matricularAluno(davi, redes);
        controle.matricularAluno(davi, bd);
        controle.matricularAluno(davi, paradigmas);

        controle.matricularAluno(artur, map);
        controle.matricularAluno(artur, edsw);
        controle.matricularAluno(artur, prob);
        controle.matricularAluno(artur, bd);
        controle.matricularAluno(artur, paradigmas);
        controle.matricularAluno(artur, taal);

        controle.atribuirProfessor(sabrina, map);
        controle.atribuirProfessor(sabrina, edsw);
        controle.atribuirProfessor(sabrina, bd);
        controle.atribuirProfessor(sabrina, paradigmas);
        controle.atribuirProfessor(dunfray, redes);
        controle.atribuirProfessor(dunfray, prob);
        controle.atribuirProfessor(dunfray, taal);

        System.out.println("a) Quais disciplinas um professor está ministrando: ");
        System.out.println("Sabrina: " + controle.disciplinasProfessor(sabrina) + "\n");
        System.out.println("Dunfray: " + controle.disciplinasProfessor(dunfray) + "\n");

        System.out.println("b) Qual o horário de um professor:");
        System.out.println("Sabrina: " + controle.horariosProfessor(sabrina) + "\n");
        System.out.println("Dunfray: " + controle.horariosProfessor(dunfray) + "\n");

        System.out.println("c) Quais os alunos de uma dada disciplina:");
        System.out.println("Métodos Avançados de Programação: " + controle.alunosDisciplina(map) + "\n");
        System.out.println("Técnica e Análise de Algoritmos: " + controle.alunosDisciplina(map) + "\n");

        System.out.println("d) Quais as disciplinas de um aluno:");
        System.out.println("Artur: " + controle.disciplinasAluno(artur) + "\n");
        System.out.println("Davi: " + controle.disciplinasAluno(davi) + "\n");

        System.out.println("e) Qual o horário de um aluno:");
        System.out.println("Artur: " + controle.horariosAluno(artur) + "\n");
        System.out.println("Davi: " + controle.horariosAluno(davi) + "\n");

        System.out.println("f) Qual o número de alunos de uma disciplina:");
        System.out.println("Métodos Avançados de Programação: " + controle.numeroAlunosDisciplina(taal) + "\n");
        System.out.println("Técnica e Análise de Algoritmos: " + controle.numeroAlunosDisciplina(map));

    }
}