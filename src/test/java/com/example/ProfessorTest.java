package com.example;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {

    private Professor professor;
    private Disciplina disciplina;
    private Horario horario;

    @Before
    public void setUp() {
        professor = new Professor("Sabrina");
        disciplina = new Disciplina("MAP");
        horario = new Horario("Sexta", LocalTime.of(7, 0), LocalTime.of(9, 0));
    }

    @Test
    public void deveCriarProfessorComNome(){
        assertEquals("Sabrina", professor.getNome());
    }

    @Test
    public void deveAdicionarDisciplinaAoProfessor(){
        professor.setDisciplinas(disciplina);
        assertEquals(1, professor.getDisciplinas().size());
        assertTrue(professor.getDisciplinas().contains(disciplina));
    }

    @Test
    public void deveListarDisciplinasDoProfessor(){
        professor.setDisciplinas(disciplina);
        String resultado = professor.verDisciplinas();
        assertTrue(resultado.contains("MAP"));
    }

    @Test
    public void deveListarHorariosDasDisciplinasDoProfessor(){
        disciplina.setHorarios(horario);
        professor.setDisciplinas(disciplina);
        String resultado = professor.verHorarios();
        assertTrue(resultado.contains("Disciplina: MAP"));
        assertTrue(resultado.contains("Sexta | 07:00 - 09:00"));
    }

    @Test
    public void deveFalharAoVerificarHorarioIncorreto() {
        disciplina.setHorarios(horario);
        professor.setDisciplinas(disciplina);
        String resultado = professor.verHorarios();
        assertTrue(resultado.contains("Sábado")); // Está errado, porque o horário é "Sexta"
    }

}
