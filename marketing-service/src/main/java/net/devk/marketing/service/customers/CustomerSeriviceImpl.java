package net.devk.marketing.service.customers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.dto.GetCustomerResponseDTO;
import net.devk.marketing.service.model.AttractionType;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.CustomerAddress;
import net.devk.marketing.service.model.RegistrationStatus;

@Service
class CustomerSeriviceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	@Autowired
	private BasedataService basedataService;

	@Override
	@Transactional
	public Customer createCustomer(String name, boolean legal, String economicCode, String economicSection,
			int headCount, long annualIncome, boolean hasDocuments, RegistrationStatus registrationStatus,
			String username, Long businessScaleId, Long customerTypeId, Long ownershipTypeId, Long attractionTypeId,
			Long organizationTypeId) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setRegisterDate(new Date());
		customer.setLegal(legal);
		customer.setEconomicCode(economicCode);
		customer.setEconomicSection(economicSection);
		customer.setHeadCount(headCount);
		customer.setAnnualIncome(annualIncome);
		customer.setHasDocument(hasDocuments);
		customer.setRegistrationStatus(registrationStatus);
		customer.setUsername(username);
		customer.setUsername(username);
		customer.setBusinessScale(basedataService.getOneBusinessScale(businessScaleId));
//		customer.setCustomerType(basedataService.getOneCustomerType(customerTypeId));
		customer.setOwnershipType(basedataService.getOneOwnershipType(ownershipTypeId));
		customer.setAttractionType(basedataService.getOneAttractionType(attractionTypeId));
		customer.setOrganizationType(basedataService.getOrganizationType(organizationTypeId));
		return customerRepository.save(customer);
	}

	@Override
	public CustomerAddress addAddress(Long customerId, String address, String latitude, String longitude) {
		Customer customer = customerRepository.getOne(customerId);
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setCustomer(customer);
		customerAddress.setAddress(address);
		customerAddress.setLatitude(latitude);
		customerAddress.setLongitude(longitude);
		return customerAddressRepository.save(customerAddress);
	}

	@Transactional
	@Override
	public Customer createCustomer(String name, Long businessScaleId, boolean legal, String economicSection,
			String latitude, String longitude, String address, String username) {

		Customer customer = new Customer();
		customer.setName(name);
		customer.setBusinessScale(basedataService.getOneBusinessScale(businessScaleId));
		customer.setLegal(legal);
		customer.setAttractionType(basedataService.findAttractionTypeByCode(AttractionType.ATTRACTION_TYPE_TYPE1));
		customer.setEconomicSection(economicSection);
		customer.setRegisterDate(new Date());
		customer.setRegistrationStatus(RegistrationStatus.EARLY);
		customer.setUsername(username);

		customer = customerRepository.save(customer);
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
	public Customer updateCustomer(Long customerId, String economicCode, int headCount, Long ownershipTypeId,
			Long organizationTypeId, long annualIncome) {

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
	public List<GetCustomerResponseDTO> findAllCustomersLikeByName(String name) {
		return customerRepository.findAllCustomersLikeByName(name);
	}

}
