package net.devk.marketing.service.contacts.dto;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNewContactInfoRequestDTO {
	
	private final String name;
	private final Long contactRoleId;
	
	private Collection<ContactTypeRequestDTO> details;
	

}
