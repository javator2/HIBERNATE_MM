package pl.sdacademy.hibernate;


import pl.sdacademy.hibernate.config.HibernateUtils;
import pl.sdacademy.hibernate.entity.Author;
import pl.sdacademy.hibernate.entity.Book;
import pl.sdacademy.hibernate.entity.Category;
import pl.sdacademy.hibernate.serivce.AuthorService;
import pl.sdacademy.hibernate.serivce.BookService;
import pl.sdacademy.hibernate.serivce.CategoryService;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

//        CategoryService categoryService = new CategoryService();
        BookService bookService = new BookService();

        Category category = new Category();
//        category.setName("Nowa11");
//        categoryService.deleteAll();


//        AuthorService authorService = new AuthorService();
        Author author = new Author();
//        authorService.delete(4);
        author.setName("Autor");
        author.setLastname("Nazwisko");

        Set<Author> authorSet = new HashSet<>();
        authorSet.add(author);
        Category category1 = new Category();
        category.setName("Testowa");

        Book s = new Book();
        s.setCategory(category1);
        s.setAuthors(authorSet);
        s.setTitle("Tytuł");
        bookService.save(s);

//            authorService.deleteAll();

//        authorService.save(author);


//
//        for (Book book: bookService.findAll()) {
//            System.out.println("Tytuł: " + book.getTitle());
//            System.out.println("Autorzy: ");
//            for (Author a: book.getAuthors()) {
//                System.out.println(a.getName() + " " + a.getLastname());
//            }
//            System.out.println("Kategoria: " + book.getCategory().getName());
//        }

        HibernateUtils.closeConnection();
    }
}


