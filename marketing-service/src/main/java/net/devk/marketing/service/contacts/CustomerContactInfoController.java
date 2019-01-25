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
import net.devk.marketing.service.contacts.dto.ContactInfoQueryResultDTO;
import net.devk.marketing.service.contacts.dto.CreateNewContactInfoRequestDTO;
import net.devk.marketing.service.contacts.dto.CreateNewContactInfoResponseDTO;
import net.devk.marketing.service.customers.CustomerController;
import net.devk.marketing.service.model.ContactInfo;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + CustomerController.CUSTOMERS_ENDPOINT)
public class CustomerContactInfoController {

	private static final String CONTACT_INFO_ENDPOINT = "/contacts-info";

	@Autowired
	private ContactService contactService;

	@RequestMapping(path = "/{id}" + CONTACT_INFO_ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<CreateNewContactInfoResponseDTO> addNewContactInfo(
			@RequestBody CreateNewContactInfoRequestDTO createNewContactInfoRequestDTO,
			@PathVariable(name = "id") Long customerId) {
		ContactInfo contactInfo = contactService.createContactInfo(customerId,
				createNewContactInfoRequestDTO.getContactRoleId(), createNewContactInfoRequestDTO.getName(),
				createNewContactInfoRequestDTO.getDetails());
		return ResponseEntity.status(HttpStatus.CREATED).body(new CreateNewContactInfoResponseDTO(contactInfo.getId()));
	}

	@RequestMapping(path = "/{id}" + CONTACT_INFO_ENDPOINT, method = RequestMethod.GET)
	public ResponseEntity<List<ContactInfoQueryResultDTO>> getAllContactInfo(
			@PathVariable(name = "id") Long customerId) {
		return ResponseEntity.ok(contactService.findAllContactsInfo(customerId));
	}

}
