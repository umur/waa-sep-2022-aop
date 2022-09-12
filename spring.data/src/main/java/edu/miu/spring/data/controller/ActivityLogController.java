package edu.miu.spring.data.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

}
