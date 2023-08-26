package edu.miu.lab5aop.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String comment;

    @ManyToOne
    //@JoinColumn(name = "post_id")
    private Post post;

}
