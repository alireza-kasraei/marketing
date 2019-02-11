package net.devk.marketing.service.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.contacts.dto.UpdateContactDetailInfoRequestDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + ContactDetailInfoController.CONTACT_INFO_DETAILS_ENDPOINT)
public class ContactDetailInfoController {

	static final String CONTACT_INFO_DETAILS_ENDPOINT = "/contact-detail-info";

	@Autowired
	private ContactService contactService;

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateContactInfoDetails(@PathVariable("id") Long contactDetailInfoId,
			@RequestBody UpdateContactDetailInfoRequestDTO updateContactDetailInfoRequestDTO) {
		contactService.updateContactDetailInfo(contactDetailInfoId, updateContactDetailInfoRequestDTO.getContactData(),
				updateContactDetailInfoRequestDTO.getContactTypeId());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteContactInfoDetails(@PathVariable("id") Long contactDetailInfoId) {
		contactService.deleteContactDetailInfo(contactDetailInfoId);
		return ResponseEntity.noContent().build();
	}

}
