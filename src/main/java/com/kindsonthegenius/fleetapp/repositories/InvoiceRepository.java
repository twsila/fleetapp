package com.kindsonthegenius.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindsonthegenius.fleetapp.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
