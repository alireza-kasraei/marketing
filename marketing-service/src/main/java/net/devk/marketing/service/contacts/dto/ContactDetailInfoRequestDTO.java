package net.devk.marketing.service.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactDetailInfoRequestDTO {

	private final Long contactTypeId;
	private final String contactData;

}
