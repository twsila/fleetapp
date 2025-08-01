package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
