package com.docestate.demo.back.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RealEstateDTO {

	private final String name;
	private final String address;

	@JsonCreator
	public RealEstateDTO(@JsonProperty("name") String name,
	                     @JsonProperty("address") String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}
