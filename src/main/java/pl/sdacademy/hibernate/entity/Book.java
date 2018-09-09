package pl.sdacademy.hibernate.entity;

// Encja ?


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //można dodać do adnotacji inną nazwę
    //@Column(name = "Tytuł" )
    @Column
    private String title;
    @Column
    private String isbn;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Author> authors;

    public Book(String title, String isbn, Category category, Publisher publisher, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.category = category;
        this.publisher = publisher;
        this.authors = authors;
    }


    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}

