package hibernateplus;

import hibernateplus.config.HibernateUtil;
import hibernateplus.entities.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class SelectBooks {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("FROM Book");
            List<Book> bookList = query.getResultList();
            for (Book book : bookList) {
                System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getQty() + " " + book.getPrice());
            }
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
