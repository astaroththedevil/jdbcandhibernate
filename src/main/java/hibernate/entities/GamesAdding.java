package hibernate.entities;

import hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class GamesAdding {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();

        Games game = new Games();
        game.setTitle("Grand Theft Auto V");
        game.setDeveloper("Rockstar Games");
        game.setYear(2014);

        entityManager.getTransaction().begin();

        entityManager.persist(game);

        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
