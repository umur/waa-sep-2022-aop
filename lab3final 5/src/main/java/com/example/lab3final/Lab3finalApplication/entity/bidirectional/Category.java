package com.example.lab3final.Lab3finalApplication.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category") //mapped by to prevent creation of new table
   private List<Product> products;
}
