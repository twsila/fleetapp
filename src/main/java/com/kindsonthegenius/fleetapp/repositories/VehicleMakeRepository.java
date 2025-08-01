package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.VehicleMake;


public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Integer> {

}
