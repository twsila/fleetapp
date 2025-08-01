package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.VehicleStatus;


public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {

}
