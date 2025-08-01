package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.Location;


public interface LocationRepository extends JpaRepository<Location, Integer> {

}
