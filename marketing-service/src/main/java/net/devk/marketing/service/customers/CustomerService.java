package net.devk.marketing.service.customers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.marketing.service.customers.dto.CustomerFindAllQueryResultDTO;
import net.devk.marketing.service.model.Customer;

public interface CustomerService {

	/**
	 * creates a new {@link Customer} for the first step on "create customer wizard"
	 * 
	 * @param name
	 * @param businessScaleId
	 * @param legal
	 * @param economicSection
	 * @param latitude
	 * @param longitude
	 * @param address
	 * @param username
	 * @return
	 */
	public Customer createCustomer(String name, Long businessScaleId, boolean legal, String economicSection,
			String latitude, String longitude, String address, String username);

	/**
	 * updates a customer with the given customer id for the second step
	 * 
	 * @param customerId
	 * @param economicCode
	 * @param headCount
	 * @param ownershipTypeId
	 * @param organizationTypeId
	 * @param annualIncome
	 * @return
	 */
	public Customer updateCustomer(Long customerId, String economicCode, Integer headCount, Long ownershipTypeId,
			Long organizationTypeId, Long annualIncome);

	/**
	 * @see JpaRepository#getOne(Object)
	 */
	public Customer getOneCustomer(Long customerId);

	public List<CustomerFindAllQueryResultDTO> findAllCustomersLikeByName(String name);

}
