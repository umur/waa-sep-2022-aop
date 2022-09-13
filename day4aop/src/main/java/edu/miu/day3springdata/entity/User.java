package edu.miu.day3springdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User {
    @Id
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Review> review;


}
