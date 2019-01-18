package net.devk.marketing.service.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactTypeRequestDTO {

	private final Long contactTypeId;
	private final String contactData;

}
