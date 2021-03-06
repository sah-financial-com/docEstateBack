package com.docestate.demo.back.db.repositories;

import com.docestate.demo.back.db.entities.RealEstate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RealEstateRepository extends PagingAndSortingRepository<RealEstate, Long> {

	RealEstate findById(long id);

	List<RealEstate> findByName(@Param("name") String name);

}
