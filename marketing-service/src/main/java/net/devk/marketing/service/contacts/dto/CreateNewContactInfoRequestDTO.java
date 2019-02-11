package net.devk.marketing.service.contacts.dto;

import java.util.Collection;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateNewContactInfoRequestDTO {

	private final String name;
	private final Long contactRoleId;

	private final Collection<ContactDetailInfoRequestDTO> details;

}
