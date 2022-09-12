package miu.edu.project4.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String major;
        private Double gpa;

//        @OneToMany
//        List<Course> coursesTaken;

}
