package pl.sdacademy.hibernate.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> bookSet;


    public Author(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;

    }
    public Author(){}

    public String getName() {
        return name;
    }
}
