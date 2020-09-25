package spring.learning.msscbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import spring.learning.msscbrewery.web.model.BeerDto;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Pole cart")
				.beerStyle("Pale Ale")
				.build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		// To update the beer value
		
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleting beer .....");
		
	}

}
