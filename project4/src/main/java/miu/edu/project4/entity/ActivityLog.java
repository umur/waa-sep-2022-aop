package miu.edu.project4.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ActivityLog {

    @Id
    private int id;
    private int date;
    private String operation;
    private int duration;



}
