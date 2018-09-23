package pl.sdacademy.hibernate.serivce;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sdacademy.hibernate.config.HibernateUtils;
import pl.sdacademy.hibernate.dao.AuthorDao;
import pl.sdacademy.hibernate.dao.BookDao;
import pl.sdacademy.hibernate.entity.Author;
import pl.sdacademy.hibernate.entity.Book;

import java.util.List;

public class BookService {

    private static BookDao bookDao;

    private Session currentSession;
    private Transaction currentTransaction;

    public BookService() { bookDao = new BookDao();
    }

    public synchronized Session getCurrentSession(){
        return currentSession;
    }

    public synchronized Session openCurrentSession(){
        if(currentSession == null) {
            currentSession = HibernateUtils.getSession();
            currentTransaction = currentSession.beginTransaction();
        }
        return currentSession;
    }

    public synchronized void closeCurrentSession(){
        currentTransaction.commit();
    }


    public Book save(Book book) {
        bookDao.openCurrentSession();
        bookDao.save(book)
        bookDao.closeCurrentSession();
        return book;
    }

    public void update(Book book) {
        bookDao.openCurrentSession();
        bookDao.update(book);
        bookDao.closeCurrentSession();
    }

    public void delete(int id) {
        bookDao.openCurrentSession();
        Book book = bookDao.findByID(id);
        bookDao.delete(book);
        bookDao.closeCurrentSession();
    }

    public Book findByID(int id) {
        bookDao.openCurrentSession();
        Book book = bookDao.findByID(id);
        bookDao.closeCurrentSession();
        return book;
    }

    public List<Book> findAll() {
        bookDao.openCurrentSession();
        List<Book> bookList = bookDao.findAll();
        bookDao.closeCurrentSession();
        return bookList;
    }

    public void deleteAll() {
        bookDao.openCurrentSession();
        bookDao.deleteAll();
        bookDao.closeCurrentSession();
    }
}