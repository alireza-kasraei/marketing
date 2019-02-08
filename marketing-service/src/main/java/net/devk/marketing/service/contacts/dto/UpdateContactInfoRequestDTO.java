package net.devk.marketing.service.contacts.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateContactInfoRequestDTO {

	private final String name;
	private final Long contactRoleId;

}
