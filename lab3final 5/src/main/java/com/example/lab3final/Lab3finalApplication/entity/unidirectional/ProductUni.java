package com.example.lab3final.Lab3finalApplication.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductUni {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private int rating;

}
