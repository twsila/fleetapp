package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleModel;
import com.kindsonthegenius.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	

	//Return List of VehicleModes
	public List<VehicleModel> getVehicleModels(){
		return vehicleModelRepository.findAll();		
	}
	
	//Add New VehicleMode
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}

	// Get By Id
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}
	
	//Delete VehicleMode
	public void delete(int id) {
		vehicleModelRepository.deleteById(id);
	}		
}
