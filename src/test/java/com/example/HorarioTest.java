package com.example;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HorarioTest {

    private Horario horario;

    @BeforeEach
    void setUp(){
        horario = new Horario("Segunda", LocalTime.of(7, 0), LocalTime.of(9, 0));
    }

    @Test
    void deveCriarHorarioComDadosCorretos(){
        assertEquals("Segunda", horario.getDia());
        assertEquals(LocalTime.of(7, 0), horario.getHoraInicio());
        assertEquals(LocalTime.of(9, 0), horario.getHoraFim());
    }

    @Test
    void deveRetornarStringFormatadaCorretamente(){
        String resultado = horario.toString();
        assertTrue(resultado.contains("07:00"));
        assertTrue(resultado.contains("09:00"));
    }
}
