package edu.miu.spring.data.entity;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Data
@Entity

public class Product {

    @Id
    private int id;
    @Column(name = "product_name")
    private String name;

    @Column(name = "product_col")
    private int price;

    private int rating;

    @ManyToOne
    private Category category;

}
