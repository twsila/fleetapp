package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.VehicleMovement;

public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}
