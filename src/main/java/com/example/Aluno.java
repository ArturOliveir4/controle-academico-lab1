package com.example;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String nome;
    private List<Disciplina> disciplinas;

    public Aluno() {}

    public Aluno(String nome){
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setDisciplinas(Disciplina disciplina){
        disciplina.setAlunos(this);
        this.disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }

    public String verDisciplinas(){
        StringBuilder sb = new StringBuilder();
        for(Disciplina dis : this.disciplinas){
            sb.append(dis.toString()).append("\n");
        }
        return sb.toString();
    }

    public String verHorarios() {
        StringBuilder sb = new StringBuilder();
        for(Disciplina dis : this.disciplinas){
            sb.append("Disciplina: ").append(dis.getNome()).append("\n");
            if(!dis.getHorarios().isEmpty()){
                for(Horario hor : dis.getHorarios()){
                    sb.append(hor.getDia()).append(" | ").append(hor.getHoraInicio()).append(" - ").append(hor.getHoraFim()).append("\n");
                }
            }else{
                sb.append("Sem horários!");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
