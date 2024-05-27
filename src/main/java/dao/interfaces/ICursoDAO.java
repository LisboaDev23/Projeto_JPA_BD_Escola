package dao.interfaces;

import domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface ICursoDAO {

    public Curso cadastrarCurso(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Curso curso);
    public Boolean excluirCurso(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Curso curso);
    public List<Curso> buscarTodosCursos(EntityManagerFactory entityManagerFactory, EntityManager entityManager);
    public Curso buscarCursoPorId(EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id);
    public Boolean excluirCursoPorId (EntityManagerFactory entityManagerFactory, EntityManager entityManager,Long id);
}
