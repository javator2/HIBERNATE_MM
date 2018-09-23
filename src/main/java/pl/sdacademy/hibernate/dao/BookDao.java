package pl.sdacademy.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import pl.sdacademy.hibernate.config.HibernateUtils;
import pl.sdacademy.hibernate.entity.Book;
import pl.sdacademy.hibernate.entity.Category;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookDao implements DaoInterface<Book> {

    private Session currentSession;
    private Transaction currentTransaction;

    public BookDao() {

    }

    public Session getCurrentSession(){
        return currentSession;
    }



    public Book save(Book entity) {
        try {
            getCurrentSession().save(entity);
        } catch (HibernateException e) {}
            return entity;
    }

    public void update(Book entity) {
        try {
            getCurrentSession().update(entity);
        } catch (HibernateException e){}
    }

    public Book findByID(int id) {
        Book book = getCurrentSession().find(Book.class, id);
        return book;
    }

    public void delete(Book entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteAll() {
        String sql = "delete from Book";
        Query query = getCurrentSession().createQuery(sql);
        query.executeUpdate();
    }

    public List<Book> findAll() {

        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);

        return getCurrentSession().createQuery(criteriaQuery).getResultList();


//        List<Book> bookList = getCurrentSession().createQuery("from " + Book.class.getName()).list();
//        return bookList;
    }

    public List<Category> findByName(String name) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);

        Root<Category> root = criteriaQuery.from(Category.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        Query<Category> categoryQuery = getCurrentSession().createQuery(criteriaQuery);

        return categoryQuery.getResultList();
    }

    public synchronized Session openCurrentSession() {
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
