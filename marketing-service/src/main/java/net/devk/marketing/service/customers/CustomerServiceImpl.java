package net.devk.marketing.service.customers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.dto.CustomerFindAllQueryResultDTO;
import net.devk.marketing.service.customers.dto.CustomerFindOneQueryResultDTO;
import net.devk.marketing.service.model.AttractionStatus;
import net.devk.marketing.service.model.AttractionType;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.CustomerAddress;
import net.devk.marketing.service.model.RegistrationStatus;
import net.devk.marketing.service.util.DateUtils;

@Service
class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AttractionStatusRepository attractionStatusRepository;

	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	@Autowired
	private BasedataService basedataService;

	@Transactional
	@Override
	public Customer createCustomer(String name, Long businessScaleId, boolean legal, String economicSection,
			String latitude, String longitude, String address, String username) {

		final Date now = DateUtils.now();
		Customer customer = new Customer();
		customer.setName(name);
		customer.setBusinessScale(basedataService.getOneBusinessScale(businessScaleId));
		customer.setLegal(legal);
		customer.setEconomicSection(economicSection);
		customer.setRegisterDate(now);
		customer.setRegistrationStatus(RegistrationStatus.EARLY);
		customer.setUsername(username);
		customer = customerRepository.save(customer);

		setCustomerAttractionStatus(customer.getId(), AttractionType.ATTRACTION_TYPE_TYPE1);

		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setCustomer(customer);
		customerAddress.setAddress(address);
		customerAddress.setLatitude(latitude);
		customerAddress.setLongitude(longitude);
		customerAddressRepository.save(customerAddress);
		return customer;
	}

	@Transactional
	@Override
	public Customer updateCustomer(Long customerId, String economicCode, Integer headCount, Long ownershipTypeId,
			Long organizationTypeId, Long annualIncome) {

		Optional<Customer> optional = customerRepository.findById(customerId);
		// TODO FIXME change it with CustomerNotFoundException type
		Customer customer = optional.orElseThrow(() -> new RuntimeException("customer not found!"));
		customer.setHeadCount(headCount);
		customer.setEconomicCode(economicCode);
		customer.setOwnershipType(basedataService.getOneOwnershipType(ownershipTypeId));
		customer.setOrganizationType(basedataService.getOrganizationType(organizationTypeId));
		customer.setAnnualIncome(annualIncome);
		customer.setRegistrationStatus(RegistrationStatus.FINISHED);
		return customerRepository.save(customer);
	}

	@Override
	public Customer getOneCustomer(Long customerId) {
		return customerRepository.getOne(customerId);
	}

	@Override
	public List<CustomerFindAllQueryResultDTO> findAllCustomersLikeByName(String name) {
		return customerRepository.findAllCustomersLikeByName(name);
	}

	@Override
	public void setCustomerAttractionStatus(Long customerId, String attractionTypeCode) {
		Date now = DateUtils.now();
		AttractionStatus attractionStatus = new AttractionStatus();
		attractionStatus.setCustomer(customerRepository.getOne(customerId));
		attractionStatus.setRegisterDate(now);
		attractionStatus.setAttractionType(basedataService.findAttractionTypeByCode(attractionTypeCode));
		attractionStatusRepository.save(attractionStatus);
	}

	@Override
	public CustomerFindOneQueryResultDTO findCustomerQueryResultById(Long customerId) {
		return customerRepository.findCustomerQueryResultById(customerId);
	}

}
