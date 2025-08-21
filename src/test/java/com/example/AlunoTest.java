package com.example;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {

    private Aluno aluno;
    private Disciplina disciplina;
    private Horario horario;

    @BeforeEach
    void setUp() {
        aluno = new Aluno("Artur");
        disciplina = new Disciplina("MAP");
        horario = new Horario("Sexta", LocalTime.of(7, 0), LocalTime.of(9, 0));
    }

    @Test
    void deveCriarAlunoComNome(){
        assertEquals("Artur", aluno.getNome());
    }

    @Test
    void deveAdicionarDisciplinaAoAluno() {
        aluno.setDisciplinas(disciplina);
        assertEquals(1, aluno.getDisciplinas().size());
        assertTrue(aluno.getDisciplinas().contains(disciplina));
        assertEquals(1, disciplina.getAlunos().size());
    }

    @Test
    void deveListarDisciplinasDoAluno() {
        aluno.setDisciplinas(disciplina);
        String resultado = aluno.verDisciplinas();
        assertTrue(resultado.contains("Matemática"));
    }

    @Test
    void deveListarHorariosDasDisciplinasDoAluno() {
        disciplina.setHorarios(horario);
        aluno.setDisciplinas(disciplina);
        String resultado = aluno.verHorarios();
        assertTrue(resultado.contains("Disciplina: Matemática"));
        assertTrue(resultado.contains("Terça | 09:00 - 11:00"));
    }
}
