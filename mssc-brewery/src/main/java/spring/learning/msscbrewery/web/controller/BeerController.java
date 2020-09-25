package spring.learning.msscbrewery.web.controller;



import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring.learning.msscbrewery.service.BeerService;
import spring.learning.msscbrewery.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

	
	public BeerController(BeerService beerService) {
		super();
		this.beerService = beerService;
	}
	
	private final BeerService beerService;
	
	
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping
	public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
		BeerDto saveDto= beerService.saveNewBeer(beerDto);
		HttpHeaders headers= new HttpHeaders();
		headers.add("headerName", "Location");
		headers.add("headerValue", "/api/v1/beer"+ saveDto.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping({"/{beerId}"})
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto) {
		beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);	
	}
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable("beerId") UUID beerId) {
		beerService.deleteById(beerId);
	}
}
