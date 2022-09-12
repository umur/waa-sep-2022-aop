package com.aop.springaop.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Course_Professor_Key implements Serializable {
     private int professorId;
     private int courseId;

}
