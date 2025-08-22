package expert.model.services;

import java.util.ArrayList;
import java.util.List;

import expert.model.entities.Aluno;
import expert.model.entities.Disciplina;
import expert.model.entities.Horario;
import expert.model.entities.Professor;

public class ControleAcademicoService {

    private List<AlunoDisciplinaService> alunoDisciplinas = new ArrayList<>();
    private List<ProfessorDisciplinaService> professorDisciplinas = new ArrayList<>();

    public ControleAcademicoService() {
    }

    public void matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            throw new IllegalArgumentException("Aluno ou disciplina não podem ser null");
        }
        alunoDisciplinas.add(new AlunoDisciplinaService(aluno, disciplina));
    }

    public void atribuirProfessor(Professor professor, Disciplina disciplina) {
        if (professor == null || disciplina == null) {
            throw new IllegalArgumentException("Professor ou disciplina não podem ser null");
        }
        professorDisciplinas.add(new ProfessorDisciplinaService(professor, disciplina));
    }

    // a) Disciplinas de um professor:
    public List<Disciplina> disciplinasProfessor(Professor professor) {
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        for (ProfessorDisciplinaService professorDisciplina : professorDisciplinas) {
            if (professorDisciplina.getProfessor() == professor) {
                listaDisciplinas.add(professorDisciplina.getDisciplina());
            }
        }
        return listaDisciplinas;
    }

    // b) Horários de um professor:
    public List<Horario> horariosProfessor(Professor professor) {
        List<Horario> listaHorarios = new ArrayList<>();
        for (ProfessorDisciplinaService professorDisciplina : professorDisciplinas) {
            if (professorDisciplina.getProfessor() == professor) {
                listaHorarios.add(professorDisciplina.getDisciplina().getHorario());
            }
        }
        return listaHorarios;
    }

    // c) Alunos de uma disciplina:
    public List<Aluno> alunosDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode ser null");
        }
        List<Aluno> listaAlunos = new ArrayList<>();
        for (AlunoDisciplinaService ad : alunoDisciplinas) {
            if (ad.getDisciplina() == disciplina) listaAlunos.add(ad.getAluno());
        }
        if (listaAlunos.isEmpty()) {
            throw new IllegalArgumentException("Disciplina não tem alunos matriculados");
        }
        return listaAlunos;
    }

    // d) Disciplinas de um aluno:
    public List<Disciplina> disciplinasAluno(Aluno aluno) {
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        for (AlunoDisciplinaService alunoDisciplina : alunoDisciplinas) {
            if (alunoDisciplina.getAluno() == aluno) {
                listaDisciplinas.add(alunoDisciplina.getDisciplina());
            }
        }
        return listaDisciplinas;
    }

    // e) Horários de um aluno:
    public List<Horario> horariosAluno(Aluno aluno) {
        List<Horario> listaHorarios = new ArrayList<>();
        for (AlunoDisciplinaService ad : alunoDisciplinas) {
            if (ad.getAluno() == aluno) {
                listaHorarios.add(ad.getDisciplina().getHorario());
            }
        }
        return listaHorarios;
    }

    // f) Número de alunos de uma disciplina:
    public int numeroAlunosDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode ser null");
        }
        int count = 0;
        for (AlunoDisciplinaService ad : alunoDisciplinas) {
            if (ad.getDisciplina() == disciplina) count++;
        }
        if (count == 0) {
            throw new IllegalArgumentException("Disciplina não tem alunos matriculados");
        }
        return count;
    }
}
