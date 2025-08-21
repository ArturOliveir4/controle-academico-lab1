package com.example;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisciplinaTest {

    private Disciplina disciplina;
    private Aluno aluno;
    private Horario horario;

    @BeforeEach
    void setUp() {
        disciplina = new Disciplina("MAP");
        aluno = new Aluno("Artur");
        horario = new Horario("Segunda", LocalTime.of(7, 0), LocalTime.of(9, 0));
    }

    @Test
    void deveCriarDisciplinaComNome(){
        assertEquals("MAP", disciplina.getNome());
    }

    @Test
    void deveAdicionarHorarioNaDisciplina(){
        disciplina.setHorarios(horario);
        assertEquals(1, disciplina.getHorarios().size());
        assertTrue(disciplina.getHorarios().contains(horario));
    }

    @Test
    void deveAdicionarAlunoNaDisciplina(){
        disciplina.setAlunos(aluno);
        assertEquals(1, disciplina.getAlunos().size());
        assertTrue(disciplina.getAlunos().contains(aluno));
    }

    @Test
    void deveRetornarNumeroDeAlunos(){
        disciplina.setAlunos(aluno);
        assertEquals(1, disciplina.numeroAlunos());
    }

    @Test
    void deveListarAlunosDaDisciplina(){
        disciplina.setAlunos(aluno);
        String resultado = disciplina.verAlunos();
        assertTrue(resultado.contains("Artur"));
    }
}
