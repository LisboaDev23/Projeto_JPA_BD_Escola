import dao.classes.CursoDAO;
import dao.interfaces.ICursoDAO;
import domain.Curso;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CursoTest {
    private ICursoDAO cursoDAO;

    public CursoTest(){
        cursoDAO = new CursoDAO();
    }

    @Test
    public void cadastrar(){
        Curso curso = new Curso();
        curso.setNomeCurso("Engenharia de Software");
        curso.setCodigoCurso("023540");
        curso.setDescricao("Curso aonde será aprendindo todas as metodologias" +
                "práticas, modelagem de softwares complexos");
        BigDecimal precoCursoEngSoft = new BigDecimal("5000.0");
        curso.setPreco(precoCursoEngSoft);
        curso = cursoDAO.cadastrarCurso(curso);
        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());
    }
}
