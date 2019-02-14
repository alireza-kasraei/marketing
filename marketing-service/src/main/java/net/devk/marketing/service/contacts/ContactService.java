package net.devk.marketing.service.contacts;

import java.util.Collection;
import java.util.List;

import net.devk.marketing.service.contacts.dto.ContactDetailInfoQueryResultDTO;
import net.devk.marketing.service.contacts.dto.ContactDetailInfoRequestDTO;
import net.devk.marketing.service.contacts.dto.ContactInfoQueryResultDTO;
import net.devk.marketing.service.model.ContactDetailInfo;
import net.devk.marketing.service.model.ContactInfo;

public interface ContactService {

	public ContactInfo createContactInfo(Long customerId, Long contactRoleId, String name,
			Collection<ContactDetailInfoRequestDTO> contactTypes);

	public ContactInfoQueryResultDTO findContactInfoById(Long contactInfo);

	public ContactInfo updateContactInfo(Long contactInfoId, Long contactRoleId, String name);

	public void deleteContactInfo(Long contactInfoId);

	public List<ContactInfoQueryResultDTO> findContactInfosByCustomerId(Long customerId);

	public List<ContactDetailInfoQueryResultDTO> findContactDetailInfoByContactInfoId(Long contactInfo);

	public ContactInfo findOneContactInfo(Long contactInfo);

	public ContactDetailInfo updateContactDetailInfo(Long contactDetailInfoId, String contactData, Long contactTypeId);

	public void addContactDetailInfo(Long contactInfoId, String contactData, Long contactTypeId);

	public void addContactDetailInfo(Long contactInfoId, Collection<ContactDetailInfoRequestDTO> details);

	public void deleteContactDetailInfo(Long contactDetailInfoId);

}
