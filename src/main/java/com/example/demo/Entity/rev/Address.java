package com.example.demo.Entity.rev;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String city;
    private  String zip;
    @OneToOne(mappedBy = "address")
    private Member member;

}
