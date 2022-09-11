package edu.miu.productReview.domain;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String comment;

    //a review can only belong to one user
    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;
}
