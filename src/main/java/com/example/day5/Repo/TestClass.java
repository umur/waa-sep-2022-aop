package com.example.day5.Repo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestClass {

    @Id
    int id;
    String data;
}
