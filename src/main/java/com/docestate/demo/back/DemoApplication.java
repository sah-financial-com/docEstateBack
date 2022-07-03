package com.docestate.demo.back;

import com.docestate.demo.back.db.entities.RealEstate;
import com.docestate.demo.back.db.repositories.RealEstateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RealEstateRepository realEstateRepository) {
		return (args) -> {
			if (realEstateRepository.count() == 0) {
				// TODO initialise H2 database with schema, table, and data

				realEstateRepository.save(new RealEstate("Altes Postgebäude von 1860", "Rheinaustraße 124, 53225 Bonn"));
				realEstateRepository.save(new RealEstate("Burgerwerk", "Friedrich-Breuer-Straße 36"));
			}

			if (LOG.isDebugEnabled()) {
				for (RealEstate realEstate : realEstateRepository.findAll()) {
					LOG.info("{}", realEstate.toString());
				}
			}
		};
	}
}
