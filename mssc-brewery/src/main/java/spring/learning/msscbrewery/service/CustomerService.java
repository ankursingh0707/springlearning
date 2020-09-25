package spring.learning.msscbrewery.service;

import java.util.UUID;

import spring.learning.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomer(UUID customerID);

	CustomerDto saveNewCustomer(CustomerDto customerDto);

	void updateCustomerDetails(UUID customerId, CustomerDto customer);

	void deleteCustomer(UUID customnerId);
}
