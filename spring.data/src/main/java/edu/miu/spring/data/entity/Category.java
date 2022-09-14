package edu.miu.spring.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name ="my_category")
public class Category {

    @Id
    private int id;
    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
