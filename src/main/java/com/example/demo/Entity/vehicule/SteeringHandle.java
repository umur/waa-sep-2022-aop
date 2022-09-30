package com.example.demo.Entity.vehicule;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteeringHandle extends Vehicle {
    private String handleProp;
}
