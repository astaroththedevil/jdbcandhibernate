package hibernate.entities;

import hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class GameAddOperation {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();

        Game game = new Game();
        game.setTitle("Spiderman");
        game.setDeveloper("Insomniac Games");
        game.setYear(2018);

        entityManager.getTransaction().begin();

        entityManager.persist(game);

        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
