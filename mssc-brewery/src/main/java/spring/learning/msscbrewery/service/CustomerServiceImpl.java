package spring.learning.msscbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import spring.learning.msscbrewery.web.model.CustomerDto;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomer(UUID customerID) {
		return CustomerDto.builder().customerId(UUID.randomUUID())
				.customerName("Mark Paul")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		
		return CustomerDto.builder()
				.customerId(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateCustomerDetails(UUID customerId, CustomerDto customer) {
		//Customer Details updated		
	}

	@Override
	public void deleteCustomer(UUID customnerId) {
		log.debug("Delete the customer with customer id " +customnerId.toString());
		
	}

}
