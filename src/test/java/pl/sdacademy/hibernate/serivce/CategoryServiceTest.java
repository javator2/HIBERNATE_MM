package pl.sdacademy.hibernate.serivce;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.hibernate.dao.CategoryDao;
import pl.sdacademy.hibernate.entity.Category;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryServiceTest {

    private static CategoryDao categoryDao;

    @BeforeEach
    public void beforeTest(){
        categoryDao = new CategoryDao();
        categoryDao.openCurrentSession();
    }

    @Test
    void save() {

        Category category = new Category();
        category.setName("TestowaKategoria");
        assertNotNull(categoryDao.save(category));


    }
}