package net.devk.marketing.service.customers;

import java.security.Principal;
import java.util.List;

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
import net.devk.marketing.service.customers.dto.CustomerFindAllQueryResultDTO;
import net.devk.marketing.service.customers.dto.UpdateCustomerRequestDTO;
import net.devk.marketing.service.model.Customer;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + CustomerController.CUSTOMERS_ENDPOINT)
public class CustomerController {

	private static final String NEW_CUSTOMER_ENDPOINT = "/new";

	public static final String CUSTOMERS_ENDPOINT = "/customers";

	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = NEW_CUSTOMER_ENDPOINT, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateNewCustomerResponseDTO> createNewCustomer(
			@RequestBody CreateNewCustomerRequestDTO createNewCustomerRequestDTO, Principal principal) {

		Customer customer = customerService.createCustomer(createNewCustomerRequestDTO.getName(),
				createNewCustomerRequestDTO.getBusinessScaleId(), createNewCustomerRequestDTO.isLegal(),
				createNewCustomerRequestDTO.getEconomicSection(), createNewCustomerRequestDTO.getLatitude(),
				createNewCustomerRequestDTO.getLongitude(), createNewCustomerRequestDTO.getAddress(),
				principal.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(new CreateNewCustomerResponseDTO(customer.getId()));
	}

	@RequestMapping(path = NEW_CUSTOMER_ENDPOINT
			+ "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerRequestDTO updateCustomerRequestDTO,
			@PathVariable(name = "id") Long customerId) {
		customerService.updateCustomer(customerId, updateCustomerRequestDTO.getEconomicCode(),
				updateCustomerRequestDTO.getHeadCount(), updateCustomerRequestDTO.getOwnershipTypeId(),
				updateCustomerRequestDTO.getOrganizationTypeId(), updateCustomerRequestDTO.getAnnualIncome());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerFindAllQueryResultDTO>> findAll(
			@RequestParam(name = "name", required = false) String name) {
		return ResponseEntity.ok(customerService.findAllCustomersLikeByName(name));
	}

}
