package edu.miu.lab5aop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String title;

    @OneToMany
    @JoinColumn(name = "post_id1")
    private List<Comment> comments;
}
