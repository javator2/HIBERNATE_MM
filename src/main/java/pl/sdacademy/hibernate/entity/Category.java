package pl.sdacademy.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Book> bookSet;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public Category(String name) {
        this.name = name;

    }
}
