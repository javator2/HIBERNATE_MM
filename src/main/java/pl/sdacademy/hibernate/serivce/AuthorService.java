package pl.sdacademy.hibernate.serivce;

import pl.sdacademy.hibernate.dao.AuthorDao;
import pl.sdacademy.hibernate.entity.Author;

import java.util.List;


public class AuthorService {

    private static AuthorDao authorDao;

    public AuthorService() { authorDao = new AuthorDao();
    }

    public void save(Author author) {
        authorDao.openCurrentSession();
        authorDao.save(author);
        authorDao.closeCurrentSession();
    }

    public void update(Author author) {
        authorDao.openCurrentSession();
        authorDao.update(author);
        authorDao.closeCurrentSession();
    }

    public void delete(int id) {
        authorDao.openCurrentSession();
        Author author = authorDao.findByID(id);
        authorDao.delete(author);
        authorDao.closeCurrentSession();
    }

    public Author findByID(int id) {
        authorDao.openCurrentSession();
        Author author = authorDao.findByID(id);
        authorDao.closeCurrentSession();
        return author;
    }

    public List<Author> findAll() {
        authorDao.openCurrentSession();
        List<Author> authorList = authorDao.findAll();
        authorDao.closeCurrentSession();
        return authorList;
    }

    public void deleteAll() {
        authorDao.openCurrentSession();
        authorDao.deleteAll();
        authorDao.closeCurrentSession();
    }
}
