package com.aop.springaop.Model;

import javax.persistence.*;
@DiscriminatorColumn(name="Type", discriminatorType = DiscriminatorType.INTEGER)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String Email;



}
