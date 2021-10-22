package hibernate.entities;

import hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class GameFindOperation {
    public static void main(String[] args) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Game result = entityManager.find(Game.class, 2);
        System.out.println(result.getTitle() + "\n" + result.getDeveloper());

        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
