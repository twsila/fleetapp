package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
