package com.kindsonthegenius.fleetapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class LocationController {
	
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	@Autowired private LocationService locationService;
	
	@GetMapping("/locations")
	public String getLocations(Model model) {
		List<Location> locationList = locationService.getLocations();
		List<Country> countryList = countryService.getCountries();
		List<State> stateList = stateService.getStates();
		
		model.addAttribute("locations",locationList);
		model.addAttribute("countries",countryList);
		model.addAttribute("states",stateList);
		return "Location";
	}
	
//Begin::Temporary Code
	@GetMapping("/stateList")
    @ResponseBody
    public List<Map<String, Object>> getStatesByCountry(@RequestParam Integer countryId) {
		List<State> states = stateService.getStatesByCountryId(countryId);
		
       return states.stream().map(state -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", state.getId());
            map.put("name", state.getName());
            return map;
        }).collect(Collectors.toList()); 
		 
		
	}	
//End::Temporary Code	
	
	
	@PostMapping("/locations/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping("locations/findById")
	@ResponseBody
	public Optional<Location> findById(Integer id) {	
		return locationService.findById(id);
	}	
	
	@RequestMapping(value="/locations/update",method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping(value="/locations/delete",method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		locationService.delete(id);
		return "redirect:/locations";
	}	
	
}
