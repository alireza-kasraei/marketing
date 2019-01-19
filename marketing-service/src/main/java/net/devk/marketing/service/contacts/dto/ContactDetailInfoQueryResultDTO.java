package net.devk.marketing.service.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.devk.marketing.service.model.ContactCategory;

@Data
@AllArgsConstructor
public class ContactDetailInfoQueryResultDTO {

	private final Long contactInfoId;
	private final String contactData;
	private final Long contactTypeId;
	private final String contactTypeName;
	private final ContactCategory contactTypeCategory;

}
