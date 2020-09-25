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

import spring.learning.msscbrewery.service.CustomerService;
import spring.learning.msscbrewery.web.model.CustomerDto;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	private final CustomerService customerService;
	
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}


	@GetMapping({"/{customerId}"})
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CustomerDto> handlePost(@RequestBody CustomerDto customerDto){
		CustomerDto saveCustomer= customerService.saveNewCustomer(customerDto);
		HttpHeaders header= new HttpHeaders();
		header.add("headerName", "Location");
		header.add("headerValue", "/api/v1/customer"+ saveCustomer.getCustomerId().toString());
		return new ResponseEntity<CustomerDto>(HttpStatus.CREATED);
	}
	
	@PutMapping({"/{customerId}"})
	public ResponseEntity<CustomerDto> handleUpdate(@PathVariable UUID customerId, @RequestBody CustomerDto customer){
		customerService.updateCustomerDetails(customerId, customer);
		return new ResponseEntity<CustomerDto>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{customerId}"})
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable UUID customnerId) {
		customerService.deleteCustomer(customnerId);
	}
}
