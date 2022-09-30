package com.example.demo.repository.vehiculeRep;

import com.example.demo.Entity.vehicule.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehiculeRep<T extends Vehicle> extends CrudRepository<T,Integer> {
}




