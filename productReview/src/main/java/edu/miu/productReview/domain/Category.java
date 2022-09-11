package edu.miu.productReview.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;


    //A category can have many products
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
