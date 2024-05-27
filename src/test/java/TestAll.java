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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestAll {
    private IClienteDAO clienteDAO;
    private IMatriculaDAO matriculaDAO;
    private ICursoDAO cursoDAO;

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-System");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

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
        curso = cursoDAO.cadastrarCurso(entityManagerFactory,entityManager,curso);

        //CREATE OBJECT MATRICULA
        String codigoMatricula = "256798";
        Matricula matricula = new Matricula(codigoMatricula);
        matricula.setCliente(cliente);
        matricula.setCurso(curso);
        cliente = clienteDAO.cadastrarCliente(entityManagerFactory,entityManager,cliente);
        matricula = matriculaDAO.cadastrarMatricula(entityManagerFactory,entityManager,matricula);


        Assert.assertNotNull(cliente);
        Assert.assertNotNull(cliente.getId());
        Assert.assertNotNull(matricula);
        Assert.assertNotNull(matricula.getId());
        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());


        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void excluirEntidadesTest(){
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
        curso = cursoDAO.cadastrarCurso(entityManagerFactory,entityManager,curso);

        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());

        //CREATE OBJECT MATRICULA
        String codigoMatricula = "256798";
        Matricula matricula = new Matricula(codigoMatricula);
        matricula.setCliente(cliente);
        matricula.setCurso(curso);

        cliente = clienteDAO.cadastrarCliente(entityManagerFactory,entityManager,cliente);
        Assert.assertNotNull(cliente);
        Assert.assertNotNull(cliente.getId());

        matricula = matriculaDAO.cadastrarMatricula(entityManagerFactory,entityManager,matricula);
        Assert.assertNotNull(matricula);
        Assert.assertNotNull(matricula.getId());

        Boolean trueExcluirMatricula = matriculaDAO.excluirMatricula(entityManagerFactory,entityManager,matricula);
        Boolean trueExcluirCurso = cursoDAO.excluirCurso(entityManagerFactory,entityManager,curso);
        Boolean trueExcluirCliente = clienteDAO.excluirCliente(entityManagerFactory,entityManager,cliente);

        Assert.assertTrue(trueExcluirCliente);
        Assert.assertTrue(trueExcluirCurso);
        Assert.assertTrue(trueExcluirMatricula);
    }

    @Test
    public void buscarTodosTest(){
        List<Cliente> clienteList = new ArrayList<>();

        String nomeCliente = "Gabriel Lisboa";
        String cpfCliente = "09134960309";
        String numeroCliente = "85998523779";
        String emailCliente = "gabriel.lisboadv@gmail.com";
        String enderecoCliente = "Rua Castro Meireles, 1430 - Mondubim";
        Cliente cliente = new Cliente(nomeCliente,cpfCliente,numeroCliente,emailCliente,enderecoCliente);

        String nomeCliente2 = "Pedro Lisboa";
        String cpfCliente2 = "16533358029";
        String numeroCliente2 = "85995678299";
        String emailCliente2 = "comunistamata@gmail.com";
        String enderecoCliente2 = "Rua 2, 46 - Maraponga";
        Cliente cliente2 = new Cliente(nomeCliente2,cpfCliente2,numeroCliente2,emailCliente2,enderecoCliente2);

        clienteList.add(cliente);
        clienteList.add(cliente2);

        //CREATE CURSO
        List<Curso> cursoList = new ArrayList<>();

        Curso curso = new Curso();
        curso.setNomeCurso("Engenharia de Computação");
        curso.setCodigoCurso("254540");
        curso.setDescricao("Curso aonde será aprendindo todas as metodologias" +
                "práticas, modelagem de softwares complexos");
        BigDecimal precoCursoEngCompt = new BigDecimal("4000.0");
        curso.setPreco(precoCursoEngCompt);

        Curso curso2 = new Curso();
        curso2.setNomeCurso("Engenharia de Software");
        curso2.setCodigoCurso("3025875");
        curso2.setDescricao("Curso aonde será aprendindo todas as metodologias" +
                "práticas, modelagem de softwares complexos");
        BigDecimal precoCursoEngSoft = new BigDecimal("4000.0");
        curso2.setPreco(precoCursoEngSoft);

        cursoList.add(curso);
        cursoList.add(curso2);

        //CREATE OBJECT MATRICULA
        List<Matricula> matriculaList = new ArrayList<>();

        String codigoMatricula = "256798";
        Matricula matricula = new Matricula(codigoMatricula);
        matricula.setCliente(cliente);
        matricula.setCurso(curso);

        String codigoMatricula2 = "256665";
        Matricula matricula2 = new Matricula(codigoMatricula2);
        matricula2.setCliente(cliente2);
        matricula2.setCurso(curso2);

        matriculaList.add(matricula);
        matriculaList.add(matricula2);

        cursoDAO.cadastrarCurso(entityManagerFactory,entityManager,curso);
        cursoDAO.cadastrarCurso(entityManagerFactory,entityManager,curso2);
        List<Curso> cursosCadastrados = cursoDAO.buscarTodosCursos(entityManagerFactory, entityManager);

        System.out.println(cursoList);
        System.out.println(cursosCadastrados);
        Assert.assertEquals(cursoList, cursosCadastrados);

        clienteDAO.cadastrarCliente(entityManagerFactory,entityManager,cliente);
        clienteDAO.cadastrarCliente(entityManagerFactory,entityManager,cliente2);
        List<Cliente> clientesCadastrados = clienteDAO.buscarTodosClientes(entityManagerFactory,entityManager);

        System.out.println(clienteList);
        System.out.println(clientesCadastrados);
        Assert.assertEquals(clienteList, clientesCadastrados);

        matriculaDAO.cadastrarMatricula(entityManagerFactory,entityManager,matricula);
        matriculaDAO.cadastrarMatricula(entityManagerFactory,entityManager,matricula2);
        List<Matricula> matriculasCadastradas = matriculaDAO.buscarTodasMatriculas(entityManagerFactory,entityManager);

        System.out.println(matriculaList);
        System.out.println(matriculasCadastradas);
        Assert.assertEquals(matriculaList,matriculasCadastradas);

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void buscarPorIdTest(){
        Cliente clienteExemplo = new Cliente();
        clienteExemplo.setId(25L);
        clienteExemplo.setCpf("16533358029");
        clienteExemplo.setNome("Pedro Lisboa");
        Cliente clienteBuscado = clienteDAO.buscarClientePorId(entityManagerFactory,entityManager,25L);

        Assert.assertEquals(clienteExemplo.getId(), clienteBuscado.getId());
        Assert.assertEquals(clienteExemplo.getCpf(), clienteBuscado.getCpf());
        Assert.assertEquals(clienteExemplo.getNome(), clienteBuscado.getNome());

        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void excluirPorIdTest(){
        Boolean clienteExcluido = clienteDAO.excluirClientePorId(entityManagerFactory,entityManager,26L);
        Assert.assertTrue(clienteExcluido);
    }
}
