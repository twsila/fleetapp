package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {

}
