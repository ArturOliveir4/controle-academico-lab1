package com.example;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfessorTest {

    private Professor professor;
    private Disciplina disciplina;
    private Horario horario;

    @BeforeEach
    void setUp() {
        professor = new Professor("Sabrina");
        disciplina = new Disciplina("MAP");
        horario = new Horario("Sexta", LocalTime.of(7, 0), LocalTime.of(9, 0));
    }

    @Test
    void deveCriarProfessorComNome(){
        assertEquals("Sabrina", professor.getNome());
    }

    @Test
    void deveAdicionarDisciplinaAoProfessor(){
        professor.setDisciplinas(disciplina);
        assertEquals(1, professor.getDisciplinas().size());
        assertTrue(professor.getDisciplinas().contains(disciplina));
    }

    @Test
    void deveListarDisciplinasDoProfessor(){
        professor.setDisciplinas(disciplina);
        String resultado = professor.verDisciplinas();
        assertTrue(resultado.contains("MAP"));
    }

    @Test
    void deveListarHorariosDasDisciplinasDoProfessor(){
        disciplina.setHorarios(horario);
        professor.setDisciplinas(disciplina);
        String resultado = professor.verHorarios();
        assertTrue(resultado.contains("Disciplina: MAP"));
        assertTrue(resultado.contains("Sexta | 07:00 - 09:00"));
    }
}
