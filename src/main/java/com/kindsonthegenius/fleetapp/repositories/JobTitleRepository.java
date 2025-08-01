package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.JobTitle;


public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {

}
