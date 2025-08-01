package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	

	//Return List of EmployeeTypes
	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();		
	}
	
	//Add New EmployeeType
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}

	// Get By Id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}
	
	//Delete EmployeeType
	public void delete(int id) {
		employeeTypeRepository.deleteById(id);
	}		
}
