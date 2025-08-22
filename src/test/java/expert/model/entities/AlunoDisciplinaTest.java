package expert.model.entities;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import expert.model.services.ControleAcademicoService;


public class AlunoDisciplinaTest {
    
    private Aluno aluno;
    private Horario horario;
    private Disciplina disciplina;
    private ControleAcademicoService controle;

    @Before
    public void setUp() {
        aluno = new Aluno("Davi");
        horario = new Horario("Sexta", LocalTime.of(7, 0), LocalTime.of(9, 0));
        disciplina = new Disciplina("Métodos Avançados de Programação", horario);
        controle = new ControleAcademicoService();
        
    }

    @Test
    public void deveCriarAlunoComNome(){
        assertEquals("Davi", aluno.getNome());
    }

    @Test
    public void deveAdicionarDisciplinaAoAluno(){
        controle.matricularAluno(aluno, disciplina);
        assertEquals(1, controle.numeroAlunosDisciplina(disciplina));
        assertTrue(controle.disciplinasAluno(aluno).contains(disciplina));
    }

    @Test
    public void deveListarDisciplinasDoAluno(){
        controle.matricularAluno(aluno, disciplina);;
        List<Disciplina> resultado = controle.disciplinasAluno(aluno);
        assertTrue(resultado.contains(disciplina));
    }

    @Test
    public void deveListarHorariosDasDisciplinasDoAluno() {
        controle.matricularAluno(aluno, disciplina);
        List<Horario> resultado = controle.horariosAluno(aluno);

        assertEquals(1, resultado.size()); // só tem um horário

        Horario h = resultado.get(0);
        assertEquals("Sexta", h.getDia());
        assertEquals(LocalTime.of(7, 0), h.getHoraInicio());
        assertEquals(LocalTime.of(9, 0), h.getHoraFim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveFalharAoMatricularAlunoNull() {
        controle.matricularAluno(null, disciplina);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveFalharAoMatricularDisciplinaNull() {
        controle.matricularAluno(aluno, null);
    }

}
