package edu.miu.spring.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "my_address")
public class Address {

    @Id
    private int id;
    @Column(name = "address_street")
    private String street;
    @Column(name = "address_zip")
    private int zip;
    @Column(name= "address_city")
    private String city;

    @OneToOne
    private User user;
}