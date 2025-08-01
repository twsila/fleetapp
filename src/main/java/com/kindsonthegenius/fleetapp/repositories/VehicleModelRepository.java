package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.VehicleModel;


public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {

}
