package pl.sdacademy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.hibernate.entity.Author;
import pl.sdacademy.hibernate.entity.Book;
import pl.sdacademy.hibernate.entity.Category;
import pl.sdacademy.hibernate.entity.Publisher;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }

    public static void main(String[] args) {

        Category category = new Category("Groza");

        Category category1 = new Category("Horhor");

        Category category2 = new Category("Fantastyka");

        Publisher publisher = new Publisher("PWN", "Dworcowa 12", "Wawa");

        Author author = new Author("Znowu", "Ja");
        Author author1 = new Author("Czesław", "Kolasiński");
        Author author2 = new Author("Ziemowit", "Jeż");
        Set<Author> authors2 = new HashSet<Author>();

        Set<Author> authors = new HashSet<Author>();
        authors.add(author);
        authors.add(author1);

        Book book = new Book();
        book.setIsbn("123-123-33");
        book.setTitle("Książka o niczym");
        book.setCategory(category);
        book.setPublisher(publisher);
        book.setAuthors(authors);

        Book book1 = new Book();

        book1.setIsbn("123-123-32");
        book1.setTitle("Chłop i");
        book1.setCategory(category1);
        book1.setPublisher(publisher);
        book1.setAuthors(authors2);
        Book book2 = new Book();

        book2.setIsbn("123-123-30");
        book2.setTitle("Groza w programowaniu");
        book2.setCategory(category);
        book2.setPublisher(publisher);
        book2.setAuthors(authors);


        Session session = getSession();

        Transaction tx = session.getTransaction();

//        tx.begin();
//
//        session.save(category);
//        session.save(category1);
//        session.save(category2);
//
//        tx.commit();
        tx.begin();

        session.save(book);
        session.save(book1);
        session.save(book2);

        tx.commit();


        tx.begin();

        session.save(book1);
        session.save(book2);
        session.save(book);

        tx.commit();



        List<Book> bookList = session.createQuery("from " + Book.class.getName()).list();
        for (Book b : bookList) {


            System.out.println(b.getTitle() + " " + b.getPublisher().getName() + " " + b.getCategory().getName());
            for (Author a: b.getAuthors()) {
                System.out.println( "Autor: " + a.getName() + " " + a.getLastname());
            }

        }


//        Book book3 = session.byId(Book.class).getReference(2);
//        System.out.println(book3);
//
//        tx.begin();
//        session.delete(book3);
//        tx.commit();

        session.close();

    }

}
