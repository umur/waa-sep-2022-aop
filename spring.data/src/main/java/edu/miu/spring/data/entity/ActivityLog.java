package edu.miu.spring.data.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "my_activityLog")
public class ActivityLog {

    @Id
    private int id;
    private LocalDate date;
    private String operation;
    private int duration;
}
