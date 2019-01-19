package net.devk.marketing.service.contacts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.contacts.dto.CreateNewContactInfoRequestDTO;
import net.devk.marketing.service.contacts.dto.CreateNewContactInfoResponseDTO;
import net.devk.marketing.service.contacts.dto.GetContactInfoResponseDTO;
import net.devk.marketing.service.model.ContactInfo;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/customers")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(path = "/{id}/contacts-info", method = RequestMethod.POST)
	public ResponseEntity<CreateNewContactInfoResponseDTO> addNewContactInfo(
			@RequestBody CreateNewContactInfoRequestDTO createNewContactInfoRequestDTO,
			@PathVariable(name = "id") Long customerId) {
		ContactInfo contactInfo = contactService.createContactInfo(customerId,
				createNewContactInfoRequestDTO.getContactRoleId(), createNewContactInfoRequestDTO.getName(),
				createNewContactInfoRequestDTO.getDetails());
		return ResponseEntity.status(HttpStatus.CREATED).body(new CreateNewContactInfoResponseDTO(contactInfo.getId()));
	}

	@RequestMapping(path = "/{id}/contacts-info/{contactInfoId}", method = RequestMethod.GET)
	public ResponseEntity<GetContactInfoResponseDTO> getContactInfo(@PathVariable(name = "id") Long customerId,
			@PathVariable(name = "contactInfoId") Long contactInfoId) {
		return ResponseEntity.ok(contactService.findContactInfo(contactInfoId));
	}

	@RequestMapping(path = "/{id}/contacts-info", method = RequestMethod.GET)
	public ResponseEntity<List<GetContactInfoResponseDTO>> getAllContactInfo(
			@PathVariable(name = "id") Long customerId) {
		return ResponseEntity.ok(contactService.findAllContactsInfo(customerId));
	}

}
