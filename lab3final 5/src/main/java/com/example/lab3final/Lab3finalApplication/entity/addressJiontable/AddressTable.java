package com.example.lab3final.Lab3finalApplication.entity.addressJiontable;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddressTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private int zip;
    private String city;

    @OneToOne
    @JoinTable(name = "user_address")
    private UserAddTable user;

}
