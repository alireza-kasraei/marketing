package net.devk.marketing.service.contacts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + ContactDetailInfoController.CONTACT_INFO_DETAILS_ENDPOINT)
public class ContactDetailInfoController {

	static final String CONTACT_INFO_DETAILS_ENDPOINT = "/contact-info-details";
	
//	public ResponseEntity<?> updateContactInfoDetails(Long contactInfoDetailId , String contactDate , Long contactTypeId){}
	
	

}
