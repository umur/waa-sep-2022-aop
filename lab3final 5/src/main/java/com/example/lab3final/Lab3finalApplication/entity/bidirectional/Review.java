package com.example.lab3final.Lab3finalApplication.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

}
