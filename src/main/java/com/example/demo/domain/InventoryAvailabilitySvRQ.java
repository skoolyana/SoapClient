package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryAvailabilitySvRQ {

	
	  @JsonProperty("MajorVersion") 
	    public String majorVersion;
	    @JsonProperty("ClientId") 
	    public String clientId;
	    @JsonProperty("Username") 
	    public String username;
	    @JsonProperty("InventoryAvailabilityRQ") 
	    public InventoryAvailabilityRQ inventoryAvailabilityRQ;

}
