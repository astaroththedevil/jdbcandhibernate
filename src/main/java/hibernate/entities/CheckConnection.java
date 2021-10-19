package hibernate.entities;

import hibernate.config.HibernateUtil;
import org.hibernate.Session;

public class CheckConnection {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "select * from games";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }
}
