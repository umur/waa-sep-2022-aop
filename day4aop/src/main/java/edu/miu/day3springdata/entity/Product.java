package edu.miu.day3springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private Integer rating;

    @ManyToOne
    private Category category;

    @JoinColumn(name = "product_id")
    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Review> reviews;
}
