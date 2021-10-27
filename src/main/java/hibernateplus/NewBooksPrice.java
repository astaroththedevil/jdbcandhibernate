package hibernateplus;

import hibernateplus.config.HibernateUtil;
import hibernateplus.entities.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class NewBooksPrice {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("FROM Book");
            List<Book> bookList = query.getResultList();
            for (Book book : bookList) {
                book.setPrice(book.getPrice() * 1.2);
                System.out.println("New price is: " + book.getPrice());
            }
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------");

        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("FROM Book WHERE price > 30");
            List<Book> bookList = query.getResultList();
            for (Book book : bookList) {
                book.setQty(book.getQty() + 4);
                System.out.println("New qty is: " + book.getQty());
            }
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
