package com.example;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class DisciplinaTest {

    private Disciplina disciplina;
    private Aluno aluno;
    private Horario horario;

    @Before
    public void setUp() {
        disciplina = new Disciplina("MAP");
        aluno = new Aluno("Artur");
        horario = new Horario("Segunda", LocalTime.of(7, 0), LocalTime.of(9, 0));
    }

    @Test
    public void deveCriarDisciplinaComNome(){
        assertEquals("MAP", disciplina.getNome());
    }

    @Test
    public void deveAdicionarHorarioNaDisciplina(){
        disciplina.setHorarios(horario);
        assertEquals(1, disciplina.getHorarios().size());
        assertTrue(disciplina.getHorarios().contains(horario));
    }

    @Test
    public void deveAdicionarAlunoNaDisciplina(){
        disciplina.setAlunos(aluno);
        assertEquals(1, disciplina.getAlunos().size());
        assertTrue(disciplina.getAlunos().contains(aluno));
    }

    @Test
    public void deveRetornarNumeroDeAlunos(){
        disciplina.setAlunos(aluno);
        assertEquals(1, disciplina.numeroAlunos());
    }

    @Test
    public void deveListarAlunosDaDisciplina(){
        disciplina.setAlunos(aluno);
        String resultado = disciplina.verAlunos();
        assertTrue(resultado.contains("Artur"));
    }

    @Test
    public void deveFalharAoVerificarNomeIncorretoDaDisciplina(){
        assertEquals("POO", disciplina.getNome()); 
    }

}
