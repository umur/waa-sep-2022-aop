package edu.miu.day3springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
