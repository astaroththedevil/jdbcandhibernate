package hibernate.entities;

import hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class UserAddOperation {
    public static void main(String[] args) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();

        User user = new User();
        user.setFirstName("Filip");
        user.setLastName("Król");

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
