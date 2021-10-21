package hibernate.entities;

import hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class GamesUpdating {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Games game = new Games();
        game = entityManager.find(Games.class, 3);
        game.setYear(2019);

        entityManager.merge(game);

        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
