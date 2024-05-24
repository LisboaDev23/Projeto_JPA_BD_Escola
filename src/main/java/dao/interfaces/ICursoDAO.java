package dao.interfaces;

import domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface ICursoDAO {

    public Curso cadastrarCurso(Curso curso);
    public Curso excluirCurso(Curso curso);
    public List<Curso> buscarTodosCursos();
    public Curso buscarCursoPorId(Long id);
    public void excluirCursoPorId (Long id);
    public void fecharConexao(EntityManagerFactory entityManagerFactory, EntityManager entityManager);
}
