package com.example.lab3final.Lab3finalApplication.entity.reviewJointable;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ReviewTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;
    @ManyToOne
    private UserTable customer;
}
