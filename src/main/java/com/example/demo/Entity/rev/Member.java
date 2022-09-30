package com.example.demo.Entity.rev;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    @OneToOne
    private Address address;
}
