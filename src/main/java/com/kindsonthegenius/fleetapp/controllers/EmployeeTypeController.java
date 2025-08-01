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

import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	@Autowired private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeetypes")
	public String getEmployeeTypes(Model model) {
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		
		model.addAttribute("employeeTypes",employeeTypeList);
		return "EmployeeType";
	}
	
	
	
	@PostMapping("/employeetypes/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}
	
	@RequestMapping("employeetypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(Integer id) {	
		return employeeTypeService.findById(id);
	}	
	
	@RequestMapping(value="/employeetypes/update",method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}
	
	@RequestMapping(value="/employeetypes/delete",method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		employeeTypeService.delete(id);
		return "redirect:/employeeTypes";
	}
}
