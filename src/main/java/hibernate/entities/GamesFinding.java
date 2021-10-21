package hibernate.entities;

import hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class GamesFinding {
    public static void main(String[] args) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Games result = entityManager.find(Games.class, 2);
        System.out.println(result.getTitle() + "\n" + result.getDeveloper());

        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
