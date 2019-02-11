package net.devk.marketing.service.contacts.dto;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddContactDetailInfoRequestDTO {
	private final Collection<ContactDetailInfoRequestDTO> details;
}
