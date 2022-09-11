package com.example.lab3final.Lab3finalApplication.entity.addressJoincolumn;

import lombok.Data;

import javax.persistence.*;

@Table(name = "addresscol")
@Data
@Entity
public class Addresscol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private int zip;
    private String city;

    @OneToOne
    private Customercol customer;

}
