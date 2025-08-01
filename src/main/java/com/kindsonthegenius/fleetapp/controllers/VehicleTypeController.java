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

import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {
	@Autowired private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicletypes")
	public String getVehicleTypes(Model model) {
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		
		model.addAttribute("vehicleTypes",vehicleTypeList);
		return "VehicleType";
	}
	
	
	
	@PostMapping("/vehicletypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping("vehicletypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(Integer id) {	
		return vehicleTypeService.findById(id);
	}	
	
	@RequestMapping(value="/vehicletypes/update",method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping(value="/vehicletypes/delete",method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicleTypes";
	}
}
