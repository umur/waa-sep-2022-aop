package edu.miu.lab5aop.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    private String zip;

    private String city;

}
