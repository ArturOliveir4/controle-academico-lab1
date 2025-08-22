package expert.model.entities;

public class Professor {
    
    private String nome; 

    public Professor(String nome){
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser null ou vazio");
        }
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}