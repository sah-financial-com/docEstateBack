package com.docestate.demo.back.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class RealEstateDTO {

	private final String id;
	private final String name;
	private final String address;

	@JsonCreator
	public RealEstateDTO(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}
