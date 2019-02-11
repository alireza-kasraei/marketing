package net.devk.marketing.service.contacts.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateContactDetailInfoRequestDTO {

	private final String contactData;
	private final Long contactTypeId;

}
