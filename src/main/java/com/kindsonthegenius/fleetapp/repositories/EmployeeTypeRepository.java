package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.EmployeeType;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {

}
