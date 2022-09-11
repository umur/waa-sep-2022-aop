package com.example.lab3final.Lab3finalApplication.entity.addressJoincolumn;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customercol")
public class Customercol {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String email;
   private String password;
   private  String firstName;
   private String lastname;

   @OneToOne(mappedBy = "customer")
   private Addresscol address;


}
