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

    @ManyToMany
    @JoinColumn(name="students_id")
    List<Student> students;

    @ManyToMany(mappedBy = "professors")
    List<Course>courses;

}
