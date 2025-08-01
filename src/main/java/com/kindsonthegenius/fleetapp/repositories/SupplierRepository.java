package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
