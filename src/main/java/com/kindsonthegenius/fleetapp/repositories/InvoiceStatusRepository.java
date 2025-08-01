package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.InvoiceStatus;


public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Integer> {

}
