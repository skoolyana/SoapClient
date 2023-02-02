package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryProduct {

	@JsonProperty("Sequence") 
    public String sequence;
    @JsonProperty("ComponentCode") 
    public String componentCode;
    @JsonProperty("InventoryKeyCode") 
    public String inventoryKeyCode;
    @JsonProperty("FreeSale") 
    public String freeSale;
    @JsonProperty("InventoryComponent") 
    public InventoryComponent inventoryComponent;
	
	
}
