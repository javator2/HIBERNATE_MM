package pl.sdacademy.hibernate.serivce;

import pl.sdacademy.hibernate.dao.AuthorDao;
import pl.sdacademy.hibernate.dao.BookDao;
import pl.sdacademy.hibernate.entity.Author;
import pl.sdacademy.hibernate.entity.Book;

import java.util.List;

public class BookService {

    private static BookDao bookDao;

    public BookService() { bookDao = new BookDao();
    }

    public Book save(Book book) {
        bookDao.openCurrentSession();
        bookDao.save(book);
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