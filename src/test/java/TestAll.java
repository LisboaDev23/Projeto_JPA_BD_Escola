import dao.classes.ClienteDAO;
import dao.classes.CursoDAO;
import dao.classes.MatriculaDAO;
import dao.interfaces.IClienteDAO;
import dao.interfaces.ICursoDAO;
import dao.interfaces.IMatriculaDAO;
import domain.Cliente;
import domain.Curso;
import domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TestAll {

    private IClienteDAO clienteDAO;
    private IMatriculaDAO matriculaDAO;
    private ICursoDAO cursoDAO;

    public TestAll(){
        clienteDAO = new ClienteDAO();
        cursoDAO = new CursoDAO();
        matriculaDAO = new MatriculaDAO();
    }

    @Test
    public void cadastrarEntidadesTest(){
        String nomeCliente = "Gabriel Lisboa";
        String cpfCliente = "09134960309";
        String numeroCliente = "85998523779";
        String emailCliente = "gabriel.lisboadv@gmail.com";
        String enderecoCliente = "Rua Castro Meireles, 1430 - Mondubim";
        Cliente cliente = new Cliente(nomeCliente,cpfCliente,numeroCliente,emailCliente,enderecoCliente);
        //CREATE CURSO
        Curso curso = new Curso();
        curso.setNomeCurso("Engenharia de Computação");
        curso.setCodigoCurso("254540");
        curso.setDescricao("Curso aonde será aprendindo todas as metodologias" +
                "práticas, modelagem de softwares complexos");
        BigDecimal precoCursoEngSoft = new BigDecimal("4000.0");
        curso.setPreco(precoCursoEngSoft);
        curso = cursoDAO.cadastrarCurso(curso);

        //CREATE OBJECT MATRICULA
        String codigoMatricula = "256798";
        Matricula matricula = new Matricula(codigoMatricula);
        matricula.setCliente(cliente);
        matricula.setCurso(curso);
        cliente = clienteDAO.cadastrarCliente(cliente);
        matricula = matriculaDAO.cadastrarMatricula(matricula);


        Assert.assertNotNull(cliente);
        Assert.assertNotNull(cliente.getId());
        Assert.assertNotNull(matricula);
        Assert.assertNotNull(matricula.getId());
        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());
    }

    public void excluirEntidadesTest(){

    }
}
