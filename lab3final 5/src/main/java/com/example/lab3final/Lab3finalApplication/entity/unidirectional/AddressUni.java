package com.example.lab3final.Lab3finalApplication.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddressUni {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private int zip;
    private String city;

}
