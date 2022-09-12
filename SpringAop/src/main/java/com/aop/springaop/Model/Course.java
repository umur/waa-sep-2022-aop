package com.aop.springaop.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private int credit;

    @ManyToMany
    @JoinColumn(name="students_id")
    List<Student> students;

    @ManyToMany
    @JoinColumn(name="professors_id")
    List<Professor>professors;


}
