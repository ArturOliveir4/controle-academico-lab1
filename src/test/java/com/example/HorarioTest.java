package com.example;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class HorarioTest {

    private Horario horario;

    @Before
    public void setUp(){
        horario = new Horario("Segunda", LocalTime.of(7, 0), LocalTime.of(9, 0));
    }

    @Test
    public void deveCriarHorarioComDadosCorretos(){
        assertEquals("Segunda", horario.getDia());
        assertEquals(LocalTime.of(7, 0), horario.getHoraInicio());
        assertEquals(LocalTime.of(9, 0), horario.getHoraFim());
    }

    @Test
    public void deveRetornarStringFormatadaCorretamente(){
        String resultado = horario.toString();
        assertTrue(resultado.contains("07:00"));
        assertTrue(resultado.contains("09:00"));
    }
}
