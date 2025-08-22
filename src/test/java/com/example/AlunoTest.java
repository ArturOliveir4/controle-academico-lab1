package com.example;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

    private Aluno aluno;
    private Disciplina disciplina;
    private Horario horario;

    @Before
    public void setUp() {
        aluno = new Aluno("Davi");
        disciplina = new Disciplina("MAP");
        horario = new Horario("Sexta", LocalTime.of(7, 0), LocalTime.of(9, 0));
    }

    @Test
    public void deveCriarAlunoComNome(){
        assertEquals("Davi", aluno.getNome());
    }

    @Test
    public void deveAdicionarDisciplinaAoAluno(){
        aluno.setDisciplinas(disciplina);
        assertEquals(1, aluno.getDisciplinas().size());
        assertTrue(aluno.getDisciplinas().contains(disciplina));
        assertEquals(1, disciplina.getAlunos().size());
    }

    @Test
    public void deveListarDisciplinasDoAluno(){
        aluno.setDisciplinas(disciplina);
        String resultado = aluno.verDisciplinas();
        assertTrue(resultado.contains("MAP"));
    }

    @Test
    public void deveListarHorariosDasDisciplinasDoAluno(){
        disciplina.setHorarios(horario);
        aluno.setDisciplinas(disciplina);
        String resultado = aluno.verHorarios();
        assertTrue(resultado.contains("Disciplina: MAP"));
        assertTrue(resultado.contains("Sexta | 07:00 - 09:00"));
    }

    @Test
    public void deveFalharAoVerificarHorarioIncorreto(){
        disciplina.setHorarios(horario);
        aluno.setDisciplinas(disciplina);
        String resultado = aluno.verHorarios();
        assertTrue(resultado.contains("Sábado")); 
    }
}
