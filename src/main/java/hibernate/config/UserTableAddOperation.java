package hibernate.config;

import hibernate.entities.User;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class UserTableAddOperation {
    final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    final EntityManager entityManager = sessionFactory.createEntityManager();

    public void addUsersTable(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
