package expert.model.entities;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import expert.model.services.ControleAcademicoService;



public class DisciplinaTest {

    private Aluno aluno;
    private Horario horario;
    private Disciplina disciplina;
    private ControleAcademicoService controle;

    @Before
    public void setUp() {
        aluno = new Aluno("Artur");
        horario = new Horario("Sexta", LocalTime.of(7, 0), LocalTime.of(9, 0));
        disciplina = new Disciplina("Métodos Avançados de Programação", horario);
        controle = new ControleAcademicoService();
        
    }

    @Test
    public void deveCriarDisciplinaComNome(){
        assertEquals("Métodos Avançados de Programação", disciplina.getNome());
    }

    @Test
    public void deveAdicionarAlunoNaDisciplina(){
        controle.matricularAluno(aluno, disciplina);
        assertEquals(1, controle.numeroAlunosDisciplina(disciplina));
        assertTrue(controle.disciplinasAluno(aluno).contains(disciplina));
    }

    @Test
    public void deveRetornarNumeroDeAlunos(){
        controle.matricularAluno(aluno, disciplina);
        int resultado = controle.numeroAlunosDisciplina(disciplina);
        assertEquals(1, resultado);
    }

    @Test
    public void deveListarAlunosDaDisciplina(){
        controle.matricularAluno(aluno, disciplina);
        List<Aluno> resultado = controle.alunosDisciplina(disciplina);
        assertTrue(resultado.contains(aluno));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deveFalharAoPedirNumeroDeAlunosSemMatricula() {
        controle.numeroAlunosDisciplina(disciplina);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveFalharAoListarAlunosDeDisciplinaVazia() {
        controle.alunosDisciplina(disciplina);
    }
    
}