package com.example.lab3final.Lab3finalApplication.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "CustomerUni")
public class UserUni {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String email;
   private String password;
   private  String firstName;
   private String lastname;

   @OneToOne
   private AddressUni address;

   @OneToMany
   @JoinColumn
   private List<ReviewUni> reviews;
}
