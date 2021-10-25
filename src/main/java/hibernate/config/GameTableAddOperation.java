package hibernate.config;

import hibernate.config.HibernateUtil;
import hibernate.entities.Game;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class GameTableAddOperation {
    final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    final EntityManager entityManager = sessionFactory.createEntityManager();

    public void addGamesTable(Game game) {
        entityManager.getTransaction().begin();
        entityManager.persist(game);
        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
