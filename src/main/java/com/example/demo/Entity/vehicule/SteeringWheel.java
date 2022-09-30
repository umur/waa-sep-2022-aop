package com.example.demo.Entity.vehicule;

import com.example.demo.Entity.vehicule.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteeringWheel extends Vehicle {
    private String wheelProp;
}
