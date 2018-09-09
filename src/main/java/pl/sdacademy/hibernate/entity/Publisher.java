package pl.sdacademy.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@Entity

public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String adres;
    private String city;
    @OneToMany(mappedBy = "publisher")
    private Set<Book> bookSet;

    public Publisher(){}

    public Publisher(String name, String adres, String city) {
        this.name = name;
        this.adres = adres;
        this.city = city;
    }
}
