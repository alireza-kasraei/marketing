package net.devk.marketing.service.customers;

import net.devk.commons.util.date.DateUtils;
import net.devk.marketing.service.EntityNotFoundException;
import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.dto.CustomerFindAllQueryResultDTO;
import net.devk.marketing.service.customers.dto.CustomerFindOneQueryResultDTO;
import net.devk.marketing.service.model.*;
import net.devk.marketing.service.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    public Customer createNewCustomer(String name, Long businessScaleId, boolean legal, String economicSection,
                                      String latitude, String longitude, String address, String username) {

        final Date now = DateUtils.now();
        Customer customer = new Customer();
        customer.setName(name);
        customer.setBusinessScale(basedataService.findOneBusinessScale(businessScaleId));
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
    public Customer updateNewCustomer(Long customerId, String economicCode, Integer headCount, Long ownershipTypeId,
                                      Long organizationTypeId, Long annualIncome) {

        Customer customer = findOneCustomer(customerId);
        customer.setHeadCount(headCount);
        customer.setEconomicCode(economicCode);
        customer.setOwnershipType(basedataService.findOneOwnershipType(ownershipTypeId));
        customer.setOrganizationType(basedataService.findOrganizationType(organizationTypeId));
        customer.setAnnualIncome(annualIncome);
        customer.setRegistrationStatus(RegistrationStatus.FINISHED);
        return customerRepository.save(customer);
    }

    @Override
    public Customer findOneCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException(
                MessageUtils.generateEntityNotFoundMessage(customerId, "CustomerEntity")));
    }

//    @Override
//    public List<CustomerFindAllQueryResultDTO> findAllCustomersLikeByName(String name) {
//        return customerRepository.findAllCustomersLikeByName(name);
//    }

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

    @Override
    public List<CustomerFindAllQueryResultDTO> findAllWithPagination(String name, int pageSize, int pageNumber) {
        return customerRepository.findAllCustomersLikeByName(name, pageNumber, pageSize);
    }

    @Override
    public Customer updateCustomer(Long customerId, String name, Long businessScaleId, boolean legal,
                                   String economicSection, String economicCode, Integer headCount, Long ownershipTypeId,
                                   Long organizationTypeId, Long annualIncome) {
        Customer customer = findOneCustomer(customerId);
        customer.setName(name);
        customer.setBusinessScale(basedataService.findOneBusinessScale(businessScaleId));
        customer.setLegal(legal);
        customer.setEconomicSection(economicSection);
        customer.setEconomicCode(economicCode);
        customer.setHeadCount(headCount);
        customer.setOwnershipType(basedataService.findOneOwnershipType(ownershipTypeId));
        customer.setOrganizationType(basedataService.findOneOrganizationType(organizationTypeId));
        customer.setAnnualIncome(annualIncome);
        return customerRepository.save(customer);
    }

    @Override
    public CustomerAddress updateCustomerAddress(Long customerId, String address, String latitude, String longitude) {
        CustomerAddress customerAddress = customerAddressRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageUtils.generateEntityNotFoundMessage(customerId, "CustomerAddress")));
        customerAddress.setAddress(address);
        customerAddress.setLatitude(latitude);
        customerAddress.setLongitude(longitude);
        return customerAddressRepository.save(customerAddress);
    }

}
