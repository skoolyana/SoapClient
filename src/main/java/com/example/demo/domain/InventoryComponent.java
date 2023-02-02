package com.example.demo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryComponent {

	 	@JsonProperty("Sequence") 
	    public String sequence;
	    @JsonProperty("ConsumptionDateTime") 
	    public Date consumptionDateTime;
	    @JsonProperty("SaleDateTime") 
	    public Date saleDateTime;
	    @JsonProperty("AvailabilityInfo") 
	    public AvailabilityInfo availabilityInfo;
	    @JsonProperty("GroupRef") 
	    public GroupRef groupRef;
}
