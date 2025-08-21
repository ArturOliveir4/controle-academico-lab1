package com.example;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Horario> horarios;
    private List<Aluno> alunos;

    public Disciplina() {}

    public Disciplina(String nome){
        this.nome = nome;
        this.horarios = new ArrayList<>();   
        this.alunos = new ArrayList<>(); 
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setHorarios(Horario horario){
        this.horarios.add(horario);
    }

    public List<Horario> getHorarios(){
        return this.horarios;
    }

    public void setAlunos(Aluno aluno){
        this.alunos.add(aluno);
    }

    public List<Aluno> getAlunos(){
        return this.alunos;
    }

    public String verAlunos(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome).append(" - Alunos: \n");
        for(Aluno alu : this.alunos){
            sb.append(alu.getNome()).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public int numeroAlunos(){
        return this.alunos.size();
    }

    @Override
    public String toString() {
        return nome;
    }
}