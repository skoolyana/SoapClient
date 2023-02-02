package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailabilityInfo{
    @JsonProperty("Amount") 
    public String amount;
}