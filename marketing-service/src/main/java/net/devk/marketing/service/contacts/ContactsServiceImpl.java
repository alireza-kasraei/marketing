package net.devk.marketing.service.contacts;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.contacts.dto.ContactTypeRequestDTO;
import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.model.ContactDetailInfo;
import net.devk.marketing.service.model.ContactInfo;
import net.devk.marketing.service.model.Customer;

@Service
class ContactsServiceImpl implements ContactService {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ContactInfoRepository contactInfoRepository;

	@Autowired
	private BasedataService basedataService;

	@Override
	public ContactInfo createContactInfo(Long customerId, Long contactRoleId, String name,
			Collection<ContactTypeRequestDTO> contactTypes) {

		Customer customer = customerService.getOneCustomer(customerId);

		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setCustomer(customer);
		contactInfo.setRole(basedataService.getOneContactRole(contactRoleId));
		contactInfo.setName(name);
		final ContactInfo savedContactInfo = contactInfoRepository.save(contactInfo);

		contactTypes.stream().forEach(c -> {
			ContactDetailInfo contactDetailInfo = new ContactDetailInfo();
			contactDetailInfo.setContactData(c.getContactData());
			contactDetailInfo.setContactInfo(savedContactInfo);
			contactDetailInfo.setContactType(basedataService.getOneContactType(c.getContactTypeId()));
		});

		return savedContactInfo;
	}

}
