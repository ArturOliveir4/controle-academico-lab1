package expert.model.services;

import expert.model.entities.Disciplina;
import expert.model.entities.Professor;

public class ProfessorDisciplinaService {

    private Professor professor;
    private Disciplina disciplina;

    public ProfessorDisciplinaService(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public Professor getProfessor() { 
        return professor; 
    }

    public Disciplina getDisciplina() { 
        return disciplina; 
    }
    
}
