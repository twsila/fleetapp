package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
