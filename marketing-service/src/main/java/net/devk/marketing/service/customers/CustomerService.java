package net.devk.marketing.service.customers;

import java.util.List;

import net.devk.marketing.service.customers.dto.GetCustomerResponseDTO;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.CustomerAddress;
import net.devk.marketing.service.model.RegistrationStatus;

public interface CustomerService {

	public Customer createCustomer(String name, boolean legal, String economicCode, String economicSection,
			int headCount, long annualIncome, boolean hasDocuments, RegistrationStatus registrationStatus,
			String username, Long businessScaleId, Long customerTypeId, Long ownershipTypeId, Long attractionTypeId);

	public CustomerAddress addAddress(Long customerId, String address, String latitude, String longitude);

	public Customer createCustomer(String name, Long businessScaleId, Long customerTypeId, String economicSection,
			String latitude, String longitude, String address, String username);

	public Customer updateCustomer(Long customerId, Long companyTypeId, int headCount, Long ownershipTypeId,
			long annualIncome);

	public Customer getOneCustomer(Long customerId);

	public List<GetCustomerResponseDTO> findAllCustomersLikeByName(String name);

}
