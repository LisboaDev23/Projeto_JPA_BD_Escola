package dao.classes;

import dao.interfaces.ICursoDAO;
import domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoDAO implements ICursoDAO {

    private void abrirConexao (){

    }
    private void fecharConexao(EntityManagerFactory entityManagerFactory, EntityManager entityManager){
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Curso cadastrarCurso(Curso curso) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("JPA-System");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();
        fecharConexao(entityManagerFactory,entityManager);
        return curso;
    }

    @Override
    public Curso excluirCurso(Curso curso) {
        return null;
    }

    @Override
    public List<Curso> buscarTodosCursos() {
        return null;
    }

    @Override
    public Curso buscarCursoPorId(Long id) {
        return null;
    }

    @Override
    public void excluirCursoPorId(Long id) {

    }
}
