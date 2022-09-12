package com.aop.springaop.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("1")
public class Professor extends Person {
    private double salary;

    @OneToMany(mappedBy = "professor")
    private List<Course_Professor> course_professors;

    @OneToMany(mappedBy = "professor")
    private List<Professor_Student> professor_students;



}
