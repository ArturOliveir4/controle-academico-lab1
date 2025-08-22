package expert.model.services;

import expert.model.entities.Aluno;
import expert.model.entities.Disciplina;

public class AlunoDisciplinaService {

    private Aluno aluno;
    private Disciplina disciplina;

    public AlunoDisciplinaService(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Aluno getAluno() { 
        return aluno; 
    }
    
    public Disciplina getDisciplina() { 
        return disciplina; 
    }

}

