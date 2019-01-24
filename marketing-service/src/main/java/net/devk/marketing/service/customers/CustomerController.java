package net.devk.marketing.service.customers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.customers.dto.CreateNewCustomerRequestDTO;
import net.devk.marketing.service.customers.dto.CreateNewCustomerResponseDTO;
import net.devk.marketing.service.customers.dto.UpdateCustomerRequestDTO;
import net.devk.marketing.service.model.Customer;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateNewCustomerResponseDTO> createNewCustomer(
			@RequestBody CreateNewCustomerRequestDTO createNewCustomerRequestDTO, Principal principal) {

		String username = null;
		if (principal != null)
			username = principal.getName();

		Customer customer = customerService.createCustomer(createNewCustomerRequestDTO.getName(),
				createNewCustomerRequestDTO.getBusinessScaleId(), createNewCustomerRequestDTO.getCustomerTypeId(),
				createNewCustomerRequestDTO.getEconomicSection(), createNewCustomerRequestDTO.getLatitude(),
				createNewCustomerRequestDTO.getLongitude(), createNewCustomerRequestDTO.getAddress(), username);
		return ResponseEntity.status(HttpStatus.CREATED).body(new CreateNewCustomerResponseDTO(customer.getId()));
	}

	@RequestMapping(path = "/new/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateNewCustomer(@RequestBody UpdateCustomerRequestDTO updateCustomerRequestDTO,
			@PathVariable(name = "id") Long customerId) {
		customerService.updateCustomer(customerId, updateCustomerRequestDTO.getCompanyTypeId(),
				updateCustomerRequestDTO.getHeadCount(), updateCustomerRequestDTO.getOwnershipTypeId(),
				updateCustomerRequestDTO.getOrganizationTypeId(), updateCustomerRequestDTO.getAnnualIncome());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(@RequestParam(name = "name", required = false) String name) {
		return ResponseEntity.ok(customerService.findAllCustomersLikeByName(name));
	}

}
