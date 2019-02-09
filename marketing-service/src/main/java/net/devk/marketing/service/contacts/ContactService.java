package net.devk.marketing.service.contacts;

import java.util.Collection;
import java.util.List;

import net.devk.marketing.service.contacts.dto.ContactDetailInfoQueryResultDTO;
import net.devk.marketing.service.contacts.dto.ContactInfoQueryResultDTO;
import net.devk.marketing.service.contacts.dto.ContactTypeRequestDTO;
import net.devk.marketing.service.model.ContactInfo;

public interface ContactService {

	public ContactInfo createContactInfo(Long customerId, Long contactRoleId, String name,
			Collection<ContactTypeRequestDTO> contactTypes);

	public ContactInfoQueryResultDTO findContactInfo(Long contactInfo);

	public ContactInfo updateContactInfo(Long contactInfoId, Long contactRoleId, String name);

	public void deleteContactInfo(Long contactInfoId);

	public List<ContactInfoQueryResultDTO> findAllContactsInfo(Long customerId);

	public List<ContactDetailInfoQueryResultDTO> findContactDetailInfo(Long contactInfo);

	public ContactInfo findOneContactInfo(Long contactInfo);

}
