package net.devk.marketing.service.customers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.dto.CustomerFindAllQueryResultDTO;
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

}
