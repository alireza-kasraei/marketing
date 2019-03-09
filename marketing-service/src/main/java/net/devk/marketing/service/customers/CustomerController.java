package net.devk.marketing.service.customers;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.customers.dto.*;
import net.devk.marketing.service.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + CustomerController.CUSTOMERS_ENDPOINT)
public class CustomerController {

    public static final String CUSTOMERS_ENDPOINT = "/customers";
    private static final String NEW_CUSTOMER_ENDPOINT = "/new";
    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = NEW_CUSTOMER_ENDPOINT, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateNewCustomerResponseDTO> createNewCustomer(
            @RequestBody CreateNewCustomerRequestDTO createNewCustomerRequestDTO, Principal principal) {

        Customer customer = customerService.createNewCustomer(createNewCustomerRequestDTO.getName(),
                createNewCustomerRequestDTO.getBusinessScaleId(), createNewCustomerRequestDTO.isLegal(),
                createNewCustomerRequestDTO.getEconomicSection(), createNewCustomerRequestDTO.getLatitude(),
                createNewCustomerRequestDTO.getLongitude(), createNewCustomerRequestDTO.getAddress(),
                principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateNewCustomerResponseDTO(customer.getId()));
    }

    @RequestMapping(path = NEW_CUSTOMER_ENDPOINT
            + "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateNewCustomer(@RequestBody UpdateNewCustomerRequestDTO updateCustomerRequestDTO,
                                               @PathVariable(name = "id") Long customerId) {
        customerService.updateNewCustomer(customerId, updateCustomerRequestDTO.getEconomicCode(),
                updateCustomerRequestDTO.getHeadCount(), updateCustomerRequestDTO.getOwnershipTypeId(),
                updateCustomerRequestDTO.getOrganizationTypeId(), updateCustomerRequestDTO.getAnnualIncome());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerRequestDTO updateCustomerRequestDTO,
                                            @PathVariable(name = "id") Long customerId) {
        customerService.updateCustomer(customerId, updateCustomerRequestDTO.getName(),
                updateCustomerRequestDTO.getBusinessScaleId(), updateCustomerRequestDTO.isLegal(),
                updateCustomerRequestDTO.getEconomicSection(), updateCustomerRequestDTO.getEconomicCode(),
                updateCustomerRequestDTO.getHeadCount(), updateCustomerRequestDTO.getOwnershipTypeId(),
                updateCustomerRequestDTO.getOrganizationTypeId(), updateCustomerRequestDTO.getAnnualIncome());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/{id}/address", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomerAddress(
            @RequestBody UpdateCustomerAddressRequestDTO updateCustomerAddressRequestDTO,
            @PathVariable(name = "id") Long customerId) {
        customerService.updateCustomerAddress(customerId, updateCustomerAddressRequestDTO.getAddress(),
                updateCustomerAddressRequestDTO.getLatitude(), updateCustomerAddressRequestDTO.getLongitude());
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerFindAllQueryResultDTO>> findAllWithPagination(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageSize", required = false) int pageSize,
            @RequestParam(name = "pageNumber", required = false) int pageNumber) {
        return ResponseEntity.ok(customerService.findAllWithPagination(name, pageSize, pageNumber));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCustomerQueryResultById(@PathVariable(name = "id", required = false) Long customerId) {
        CustomerFindOneQueryResultDTO customer = customerService.findCustomerQueryResultById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else
            return ResponseEntity.notFound().build();
    }

}
