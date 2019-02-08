package net.devk.marketing.service.customers;

import java.util.List;

import net.devk.marketing.service.EntityNotFoundException;
import net.devk.marketing.service.customers.dto.CustomerFindAllQueryResultDTO;
import net.devk.marketing.service.customers.dto.CustomerFindOneQueryResultDTO;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.CustomerAddress;

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
	public Customer createNewCustomer(String name, Long businessScaleId, boolean legal, String economicSection,
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
	public Customer updateNewCustomer(Long customerId, String economicCode, Integer headCount, Long ownershipTypeId,
			Long organizationTypeId, Long annualIncome);

	/**
	 * updates customer with the given id
	 * 
	 * @param customerId
	 * @param name
	 * @param businessScaleId
	 * @param legal
	 * @param economicSection
	 * @param economicCode
	 * @param headCount
	 * @param ownershipTypeId
	 * @param organizationTypeId
	 * @param annualIncome
	 * @return
	 */
	public Customer updateCustomer(Long customerId, String name, Long businessScaleId, boolean legal,
			String economicSection, String economicCode, Integer headCount, Long ownershipTypeId,
			Long organizationTypeId, Long annualIncome);

	public CustomerAddress updateCustomerAddress(Long customerId, String address, String latitude, String longitude);

	/**
	 * returns the Customer with the given id or else throws
	 * {@link EntityNotFoundException}
	 */
	public Customer findOneCustomer(Long customerId);

	public List<CustomerFindAllQueryResultDTO> findAllCustomersLikeByName(String name);

	public void setCustomerAttractionStatus(Long customerId, String attractionTypeCode);

	public CustomerFindOneQueryResultDTO findCustomerQueryResultById(Long customerId);

}
