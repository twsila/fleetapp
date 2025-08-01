package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
