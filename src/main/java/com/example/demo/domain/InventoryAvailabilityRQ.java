package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryAvailabilityRQ{
    @JsonProperty("InventoryProduct") 
    public InventoryProduct inventoryProduct;
}
