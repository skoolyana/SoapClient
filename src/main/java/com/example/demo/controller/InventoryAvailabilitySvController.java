package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.InventoryAvailabilitySv;

@RestController
@RequestMapping("/inventory-availability")
public class InventoryAvailabilitySvController {

	
	@PostMapping(value = "availability", consumes = "application/json")
	public String getAvailability(@RequestBody InventoryAvailabilitySv inventoryAvailabilityService) {
	   
		System.out.println("ABC");
		
		return "";
	}
	
	
	
	
	
	
	
	
}
