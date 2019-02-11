package net.devk.marketing.service.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.contacts.dto.AddContactDetailInfoRequestDTO;
import net.devk.marketing.service.contacts.dto.ContactInfoQueryResultDTO;
import net.devk.marketing.service.contacts.dto.UpdateContactInfoRequestDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + ContactInfoController.CONTACTS_INFO_ENDPOINT)
public class ContactInfoController {

	static final String CONTACTS_INFO_ENDPOINT = "/contacts-info";
	@Autowired
	private ContactService contactService;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ContactInfoQueryResultDTO> getContactInfo(@PathVariable(name = "id") Long contactInfoId) {
		return ResponseEntity.ok(contactService.findContactInfoDTO(contactInfoId));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateContactInfo(@PathVariable(name = "id") Long contactInfoId,
			@RequestBody UpdateContactInfoRequestDTO updateContactInfoRequestDTO) {
		contactService.updateContactInfo(contactInfoId, updateContactInfoRequestDTO.getContactRoleId(),
				updateContactInfoRequestDTO.getName());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(path = "/{id}/contact-detail-info", method = RequestMethod.POST)
	public ResponseEntity<?> addContactDetailInfo(@PathVariable(name = "id") Long contactInfoId,
			@RequestBody AddContactDetailInfoRequestDTO addContactDetailInfoRequestDTO) {
		contactService.addContactDetailInfo(contactInfoId, addContactDetailInfoRequestDTO.getDetails());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteContactInfo(@PathVariable(name = "id") Long contactInfoId) {
		contactService.deleteContactInfo(contactInfoId);
		return ResponseEntity.noContent().build();
	}

}
