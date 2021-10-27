package hibernateplus;

import hibernateplus.config.HibernateUtil;
import hibernateplus.entities.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class BooksAddingOperation {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

//            Book book1 = new Book();
//            book1.setId(1);
//            book1.setTitle("Biała Gorączka");
//            book1.setAuthor("Jacek Hugo-Bader");
//            book1.setPrice(20d);
//            book1.setQty(10);
//            session.save(book1);
//
//            Book book2 = new Book();
//            book2.setId(2);
//            book2.setTitle("Dzienniki Kołymskie");
//            book2.setAuthor("Jacek Hugo-Bader");
//            book2.setPrice(30d);
//            book2.setQty(20);
//            session.save(book2);

            Book book3 = new Book();
            book3.setId(3);
            book3.setTitle("W rajskiej dolinie wśród zielska");
            book3.setAuthor("Jacek Hugo-Bader");
            book3.setPrice(20d);
            book3.setQty(0);
            session.save(book3);

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
