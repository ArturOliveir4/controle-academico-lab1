package expert.model.entities;

public class Disciplina {

    private String nome;
    private Horario horario;

    public Disciplina(String nome, Horario horario) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da disciplina não pode ser null ou vazio");
        }
        if (horario == null) {
            throw new IllegalArgumentException("Horario não pode ser null");
        }
        this.nome = nome;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public Horario getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return nome;
    }

}