package pl.sdacademy.hibernate.dao;

import java.util.List;

public interface DaoInterface<T>{

    public T save(T entity);
    public void update(T entity);
    public T findByID(int id);
    public void delete(T entity);
    public void deleteAll();
    public List<T> findAll();

}
