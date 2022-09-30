package com.example.demo.repository.vehiculeRep;

import com.example.demo.Entity.vehicule.SteeringHandle;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SteeringHandleRepository extends VehiculeRep<SteeringHandle> {
}
