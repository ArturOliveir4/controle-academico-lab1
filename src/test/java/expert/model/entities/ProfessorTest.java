package expert.model.entities;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import expert.model.services.ControleAcademicoService;



public class ProfessorTest {

    private Professor professor;
    private Horario horario;
    private Disciplina disciplina;
    private ControleAcademicoService controle;
    

    @Before
    public void setUp() {
        professor = new Professor("Sabrina");
        horario = new Horario("Sexta", LocalTime.of(7, 0), LocalTime.of(9, 0));
        disciplina = new Disciplina("Métodos Avançados de Programação", horario);
        controle = new ControleAcademicoService();
    }

    @Test
    public void deveCriarProfessorComNome(){
        assertEquals("Sabrina", professor.getNome());
    }

    @Test
    public void deveAdicionarDisciplinaAoProfessor(){
        controle.atribuirProfessor(professor, disciplina);
        assertTrue(controle.disciplinasProfessor(professor).contains(disciplina));
    }

    @Test
    public void deveListarDisciplinasDoProfessor(){
        controle.atribuirProfessor(professor, disciplina);
        List<Disciplina> resultado = controle.disciplinasProfessor(professor);
        assertTrue(resultado.contains(disciplina));
    }

    @Test
    public void deveListarHorariosDasDisciplinasDoProfessor(){
        controle.atribuirProfessor(professor, disciplina);
        List<Horario> resultado = controle.horariosProfessor(professor);

        assertEquals(1, resultado.size());

        Horario h = resultado.get(0);
        assertEquals("Sexta", h.getDia());
        assertEquals(LocalTime.of(7, 0), h.getHoraInicio());
        assertEquals(LocalTime.of(9, 0), h.getHoraFim());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deveFalharAoAtribuirProfessorNull() {
        controle.atribuirProfessor(null, disciplina);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveFalharAoAtribuirDisciplinaNull() {
        controle.atribuirProfessor(professor, null);
    }

}