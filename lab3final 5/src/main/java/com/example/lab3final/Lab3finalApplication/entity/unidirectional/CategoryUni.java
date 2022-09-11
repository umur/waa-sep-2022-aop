package com.example.lab3final.Lab3finalApplication.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CategoryUni {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
   private List<ProductUni> products;
}
