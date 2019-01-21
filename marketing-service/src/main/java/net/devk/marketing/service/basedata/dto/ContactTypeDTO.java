package net.devk.marketing.service.basedata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactTypeDTO {

	private final Long id;
	private final String name;
	private final String categoryName;
	private final int categoryId;

}
