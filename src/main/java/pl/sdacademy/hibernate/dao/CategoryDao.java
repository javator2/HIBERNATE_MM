package pl.sdacademy.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import pl.sdacademy.hibernate.config.HibernateUtils;
import pl.sdacademy.hibernate.entity.Category;

import java.util.List;

public class CategoryDao implements DaoInterface<Category> {

    private Session currentSession;
    private Transaction currentTransaction;

    public CategoryDao() {
        //    currentSession = HibernateUtils.getSession();
        //    currentTransaction = currentSession.beginTransaction();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Category save(Category entity) {
        try {
            getCurrentSession().save(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void update(Category entity) {
        try {
            getCurrentSession().update(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public Category findByID(int id) {
        //TODO zabezpieczenie przed nullpointerExeption
        Category category  = getCurrentSession().get(Category.class, id);
        return category;
    }

    public void delete(Category entity) {
        //TODO zabezpieczenie przed usunięciem rekordu który nie istnieje
        try {
        getCurrentSession().delete(entity);
    } catch (NullPointerException e){}}

    public void deleteAll() {
//        String sql = "delete from Category ";
//        Query query = getCurrentSession().createQuery(sql);
//        query.executeUpdate();
        List<Category> entityList = findAll();
        for (Category e: entityList) {
            delete(e);
        }

    }

    public List<Category> findAll() {
        List<Category> categories = getCurrentSession()
                .createQuery("from " + Category.class.getName())
                .list();
        return categories;
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
       // currentSession.close();
        }
    }
}
