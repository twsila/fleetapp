package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.VehicleMaintenance;


public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance, Integer> {

}
