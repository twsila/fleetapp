package com.kindsonthegenius.fleetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.State;


public interface StateRepository extends JpaRepository<State, Integer> {
	List<State> findByCountryid(Integer countryid);


}
