package com.example.lab3final.Lab3finalApplication.entity.reviewJioncolumn;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserCol {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String email;
   private String password;
   private  String firstName;
   private String lastname;


   @OneToMany(mappedBy = "userCol")
   private List<ReviewCol> reviews;
}
