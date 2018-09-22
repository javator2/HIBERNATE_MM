package pl.sdacademy.hibernate.serivce;

import pl.sdacademy.hibernate.dao.CategoryDao;
import pl.sdacademy.hibernate.entity.Category;

import java.util.List;

public class CategoryService {

    private static CategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }

    public void save(Category category) {
        categoryDao.openCurrentSession();
        categoryDao.save(category);
        categoryDao.closeCurrentSession();
    }

    public void update(Category category) {
        categoryDao.openCurrentSession();
        categoryDao.update(category);
        categoryDao.closeCurrentSession();
    }

    public void delete(int id) {
        categoryDao.openCurrentSession();
        Category category = categoryDao.findByID(id);
        categoryDao.delete(category);
        categoryDao.closeCurrentSession();
    }

    public Category findByID(int id) {
        categoryDao.openCurrentSession();
        Category categoryName = categoryDao.findByID(id);
        categoryDao.closeCurrentSession();
        return categoryName;
    }

    public void deleteAll() {
        categoryDao.openCurrentSession();
        categoryDao.deleteAll();
        categoryDao.closeCurrentSession();
    }

    public List<Category> findAll() {
        categoryDao.openCurrentSession();
        List<Category> categoryList = categoryDao.findAll();
        categoryDao.closeCurrentSession();
        return categoryList;
    }

}
