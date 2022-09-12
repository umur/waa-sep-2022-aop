package com.aop.springaop.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Course_Student_Key implements Serializable {
    private int studentId;
    private int courseId;
}
