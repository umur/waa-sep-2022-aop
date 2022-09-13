package edu.miu.day3springdata.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Address {
    @Id
    private String id;

    private String street;

    private String zip;

    private String city;

//    @OneToOne
//    private User user;
}
