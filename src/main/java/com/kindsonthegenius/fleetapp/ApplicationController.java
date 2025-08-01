package com.kindsonthegenius.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ApplicationController {
	
	@GetMapping("/")
	public String goHome() {
		return "index";
	}

	@GetMapping("/2")
	public String goHome2() {
		return "index2";
	}	

	@GetMapping("/3")
	public String goHome3() {
		return "index3";
	}	
}
