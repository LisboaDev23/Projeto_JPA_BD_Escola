package dao.classes;

import dao.interfaces.ICursoDAO;
import domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoDAO implements ICursoDAO {

    @Override
    public Curso cadastrarCurso(EntityManagerFactory entityManagerFactory, EntityManager entityManager, Curso curso) {
        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();
        return curso;
    }

    @Override
    public Curso excluirCurso(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Curso curso) {
        return null;
    }

    @Override
    public List<Curso> buscarTodosCursos(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        return null;
    }

    @Override
    public Curso buscarCursoPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {
        return null;
    }

    @Override
    public void excluirCursoPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id) {

    }
}
