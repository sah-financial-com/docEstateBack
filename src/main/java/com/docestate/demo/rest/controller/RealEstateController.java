package com.docestate.demo.rest.controller;

import com.docestate.demo.db.entities.RealEstate;
import com.docestate.demo.db.repositories.RealEstateRepository;
import com.docestate.demo.rest.RealEstateNotFoundException;
import com.docestate.demo.rest.dto.RealEstateDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RealEstateController {

	private final RealEstateRepository realEstateRepository;

	public RealEstateController(RealEstateRepository realEstateRepository) {
		this.realEstateRepository = realEstateRepository;
	}

	@GetMapping("/real-estates")
	public List<RealEstateDTO> listAllRealEstates() {
		ArrayList<RealEstateDTO> realEstateDTOList = new ArrayList<>();
		for (RealEstate realEstate : realEstateRepository.findAll()) {
			RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate.getName(), realEstate.getAddress());
			realEstateDTOList.add(realEstateDTO);
		}

		return realEstateDTOList;
	}

	@GetMapping("/real-estate/{id}")
	public RealEstateDTO readRealEstate(@PathVariable Long id) {
		Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(id);
		if (optionalRealEstate.isPresent()) {
			RealEstate realEstate = optionalRealEstate.get();
			return new RealEstateDTO(realEstate.getName(), realEstate.getAddress());
		}
		throw new RealEstateNotFoundException(id);
	}

	@PostMapping("/real-estate")
	public RealEstateDTO createRealEstate(@RequestBody RealEstateDTO newRealEstate) {
		return saveRealEstate(new RealEstate(newRealEstate.getName(), newRealEstate.getAddress()));
	}

	@PutMapping("/real-estate/{id}")
	public RealEstateDTO createOrUpdateRealEstate(@RequestBody RealEstateDTO newOrUpdatedRealEstate,
	                                              @PathVariable Long id) {
		RealEstate realEstate;
		Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(id);
		if (optionalRealEstate.isPresent()) {
			realEstate = optionalRealEstate.get();
			realEstate.setName(newOrUpdatedRealEstate.getName());
			realEstate.setAddress(newOrUpdatedRealEstate.getAddress());
		} else {
			realEstate = new RealEstate(newOrUpdatedRealEstate.getName(), newOrUpdatedRealEstate.getAddress());
		}
		return saveRealEstate(realEstate);
	}

	private RealEstateDTO saveRealEstate(RealEstate realEstate) {
		realEstateRepository.save(realEstate);
		return new RealEstateDTO(realEstate.getName(), realEstate.getAddress());
	}

	@DeleteMapping("/real-estate/{id}")
	public void deleteRealEstate(@PathVariable Long id) {
		realEstateRepository.deleteById(id);
	}
}