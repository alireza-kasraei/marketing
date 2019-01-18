package net.devk.marketing.service.customers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.customers.dto.CreateNewCustomerResponseDTO;

@RequestMapping(path=ControllersConfig.API_PREFIX)
public class CustomerController {
	
	
	public ResponseEntity<CreateNewCustomerResponseDTO> createNewCustomer(){}

}
