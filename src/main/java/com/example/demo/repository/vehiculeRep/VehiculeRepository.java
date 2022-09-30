package com.example.demo.repository.vehiculeRep;

import com.example.demo.Entity.vehicule.Vehicle;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface  VehiculeRepository extends  VehiculeRep<Vehicle>{

}

