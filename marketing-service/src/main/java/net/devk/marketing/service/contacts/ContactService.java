package net.devk.marketing.service.contacts;

import java.util.Collection;
import java.util.List;

import net.devk.marketing.service.contacts.dto.ContactTypeRequestDTO;
import net.devk.marketing.service.contacts.dto.GetContactInfoResponseDTO;
import net.devk.marketing.service.model.ContactInfo;

public interface ContactService {

	public ContactInfo createContactInfo(Long customerId, Long contactRoleId, String name,
			Collection<ContactTypeRequestDTO> contactTypes);

	public GetContactInfoResponseDTO findContactInfo(Long contactInfo);

	public List<GetContactInfoResponseDTO> findAllContactsInfo(Long customerId);

}
