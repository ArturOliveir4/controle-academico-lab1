package com.example;

import java.time.LocalTime;

public class Horario {
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Horario() {}

    public Horario(String dia, LocalTime horaInicio, LocalTime horaFim){
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public void setDia(String dia){
        this.dia = dia;
    }

    public String getDia(){
        return this.dia;
    }

    public void setHoraInicio(LocalTime horaInicio){
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraInicio(){
        return this.horaInicio;
    }

    public void setHoraFim(LocalTime horaFim){
        this.horaFim = horaFim;
    }

    public LocalTime getHoraFim(){
        return this.horaFim;
    }

    @Override
    public String toString() {
        return "Horário: " + horaInicio + " - " + horaFim;
    }

}
