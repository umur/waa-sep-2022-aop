package com.example.demo.repository.vehiculeRep;

import com.example.demo.Entity.vehicule.SteeringWheel;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SteeringWheelRepositiry extends VehiculeRep<SteeringWheel> {
}
