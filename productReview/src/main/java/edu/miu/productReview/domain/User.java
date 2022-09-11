package edu.miu.productReview.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Lab3User")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    //user can create many review
    @OneToMany(mappedBy="user")
    private List<Review> reviews;

    //user can have only one Address
    @OneToOne
    @JoinColumn(name="id_address")
    private Address address;
}
