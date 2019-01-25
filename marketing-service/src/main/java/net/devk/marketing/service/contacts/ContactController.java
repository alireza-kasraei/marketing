package net.devk.marketing.service.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.contacts.dto.ContactInfoQueryResultDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + ContactController.CONTACTS_INFO_ENDPOINT)
public class ContactController {

	static final String CONTACTS_INFO_ENDPOINT = "/contacts-info";
	@Autowired
	private ContactService contactService;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ContactInfoQueryResultDTO> getContactInfo(@PathVariable(name = "id") Long contactInfoId) {
		return ResponseEntity.ok(contactService.findContactInfo(contactInfoId));
	}

}
