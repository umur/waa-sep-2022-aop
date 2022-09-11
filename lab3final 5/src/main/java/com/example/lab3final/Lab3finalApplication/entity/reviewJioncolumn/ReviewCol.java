package com.example.lab3final.Lab3finalApplication.entity.reviewJioncolumn;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ReviewCol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;
    @ManyToOne
    private UserCol userCol;
}
