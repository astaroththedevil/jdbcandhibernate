package hibernateexercises;

import hibernateexercises.entities.Employee;
import hibernateexercises.config.HibernateUtil;
import hibernateexercises.entities.Town;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

//            OTHER WAY TO WRITE THIS METHOD WHEN WE GET ONLY ONE RECORD FROM THE BASE
//            Town myTown = session
//                    .createQuery("FROM Town WHERE name = 'Berlin'", Town.class)
//                    .getSingleResult();

            Query query = session.createQuery("FROM Town WHERE id=33");
            List<Town> townList = query.getResultList();
            for (Town town : townList) {
                session.delete(town);
                System.out.println("Deleted town is: " + town.getName());
            }
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
