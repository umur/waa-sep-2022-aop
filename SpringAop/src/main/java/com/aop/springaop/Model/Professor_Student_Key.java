package com.aop.springaop.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Professor_Student_Key implements Serializable {

    private int ProfessorId;
    private int StudentId;
}
