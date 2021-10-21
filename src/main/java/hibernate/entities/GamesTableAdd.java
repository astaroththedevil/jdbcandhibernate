package hibernate.entities;

import hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class GamesTableAdd {
    final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    final EntityManager entityManager = sessionFactory.createEntityManager();

    public void addGamesTable(Games games) {
        entityManager.getTransaction().begin();
        entityManager.persist(games);
        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
