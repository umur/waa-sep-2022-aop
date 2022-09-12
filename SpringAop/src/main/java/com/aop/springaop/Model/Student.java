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
@DiscriminatorValue("2")
public class Student extends Person{
    private double gpa;

    @OneToMany(mappedBy = "student")
    private List<Course_Student> courseStudents;

    @OneToMany(mappedBy = "student")
    private List<Professor_Student> studentProfessors;




}
