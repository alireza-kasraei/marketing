package net.devk.marketing.service.basedata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.devk.marketing.service.model.ContactCategory;

@Data
@AllArgsConstructor
public class ContactTypeDTO {

	private final Long id;
	private final String name;
	private final ContactCategory category;

}
