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

    @ManyToMany(mappedBy = "students")
    List<Course> courses;

    @ManyToMany(mappedBy = "students")
    List<Professor>professors;

}
