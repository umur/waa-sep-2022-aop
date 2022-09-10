package edu.miu.lab4.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "lab4_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne
    private Address address;
}
