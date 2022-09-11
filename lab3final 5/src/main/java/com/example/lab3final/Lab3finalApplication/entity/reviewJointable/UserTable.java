package com.example.lab3final.Lab3finalApplication.entity.reviewJointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserTable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String email;
   private String password;
   private  String firstName;
   private String lastname;

   @OneToMany
   private List<ReviewTable> reviews;
}
