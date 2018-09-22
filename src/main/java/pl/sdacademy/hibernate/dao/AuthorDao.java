package pl.sdacademy.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import pl.sdacademy.hibernate.config.HibernateUtils;
import pl.sdacademy.hibernate.entity.Author;

import java.util.List;

public class AuthorDao implements DaoInterface<Author> {

    private Session currentSession;
    private Transaction currentTransaction;

    public AuthorDao() {
//            currentSession = HibernateUtils.getSession();
//            currentTransaction = currentSession.beginTransaction();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Author save(Author entity) {
        try {
            getCurrentSession().save(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void update(Author entity) {
        try {
            getCurrentSession().update(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public Author findByID(int id) {
        //TODO zabezpieczenie przed nullpointerExeption
        Author author  = getCurrentSession().get(Author.class, id);
        return author;
    }

    public void delete(Author entity) {
        //TODO zabiezpieczenie przed nullpoint
        getCurrentSession().delete(entity);
    }

    public void deleteAll() {
        String sql = "delete from Author";
        Query query = getCurrentSession().createQuery(sql);
        query.executeUpdate();

    }

    public List<Author> findAll() {
        List<Author> authorList = getCurrentSession().createQuery("from " + Author.class.getName()).list();
        return authorList;
    }

    public Session openCurrentSession() {
        if (currentSession == null) {
            currentSession = HibernateUtils.getSession();
            currentTransaction = currentSession.beginTransaction();
        }
        return currentSession;
    }

    public void closeCurrentSession() {
        if (currentTransaction.getStatus().equals(TransactionStatus.ACTIVE)) {
        currentTransaction.commit();
//        currentSession.close();
    }}
}
