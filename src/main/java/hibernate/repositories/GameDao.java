package hibernate.repositories;

import hibernate.config.HibernateUtil;
import hibernate.entities.Game;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class GameDao implements GameDaoInterface{

    EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

    @Override
    public void persist(Game game) {
        entityManager.getTransaction().begin();
        entityManager.persist(game);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Game game) {
        entityManager.getTransaction().begin();
        entityManager.merge(game);
        entityManager.getTransaction().commit();
    }

    @Override
    public Game findById(Id id, Game game) {
        entityManager.getTransaction().begin();
        game = entityManager.find(Game.class, id);
        return game;
    }

    @Override
    public void delete(Game game) {

    }

    @Override
    public List<Game> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}

