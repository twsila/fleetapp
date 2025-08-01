package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.VehicleStatus;
import com.kindsonthegenius.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	@Autowired private VehicleStatusService vehicleStatusService;
	
	@GetMapping("/vehiclestatus")
	public String getVehicleStatuss(Model model) {
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
		
		model.addAttribute("vehicleStatus",vehicleStatusList);
		return "VehicleStatus";
	}
	
		
	@PostMapping("/vehiclestatus/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuss";
	}
	
	@RequestMapping("vehiclestatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(Integer id) {	
		return vehicleStatusService.findById(id);
	}	
	
	@RequestMapping(value="/vehiclestatus/update",method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuss";
	}
	
	@RequestMapping(value="/vehiclestatus/delete",method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatuss";
	}
}
