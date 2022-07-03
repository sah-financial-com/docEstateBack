package com.docestate.demo.rest;

public class RealEstateNotFoundException extends RuntimeException {

	public RealEstateNotFoundException(Long id) {
			super("Could not find real estate with id: " + id);
	}
}
