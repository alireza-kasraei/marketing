package net.devk.marketing.service.contacts;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.contacts.dto.ContactDetailInfoQueryResultDTO;
import net.devk.marketing.service.contacts.dto.ContactTypeRequestDTO;
import net.devk.marketing.service.contacts.dto.GetContactInfoResponseDTO;
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
	private ContactDetailInfoRepository contactDetailInfoRepository;

	@Autowired
	private BasedataService basedataService;

	@Override
	@Transactional
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
			contactDetailInfoRepository.save(contactDetailInfo);
		});

		return savedContactInfo;
	}

	@Override
	@Transactional
	public GetContactInfoResponseDTO findContactInfo(Long contactInfoId) {
		Optional<ContactInfo> contactInfoOptional = contactInfoRepository.findById(contactInfoId);
		// TODO FIXME
		ContactInfo contactInfo = contactInfoOptional.orElseThrow(() -> new RuntimeException(""));
		List<ContactDetailInfoQueryResultDTO> details = contactDetailInfoRepository
				.findContactDetailInfoByContactInfoId(contactInfoId);
		return new GetContactInfoResponseDTO(contactInfoId, contactInfo.getName(), contactInfo.getRole().getName(),
				details);
	}

	@Override
	public List<GetContactInfoResponseDTO> findAllContactsInfo(Long customerId) {
		return contactInfoRepository.findByCustomerId(customerId).stream().map(c -> findContactInfo(c.getId()))
				.collect(Collectors.toList());
	}

	@Override
	public ContactInfo getOneContactInfo(Long contactInfo) {
		return contactInfoRepository.getOne(contactInfo);
	}

}
