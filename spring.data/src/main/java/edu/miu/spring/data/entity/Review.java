package edu.miu.spring.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
public class Review {
    @Id
    private int id;
    private String comment;

    @ManyToOne
    private User user;
}
