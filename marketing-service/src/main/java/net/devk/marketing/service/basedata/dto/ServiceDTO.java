package net.devk.marketing.service.basedata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceDTO {

	private final Long id;
	private final String name;
	private final Long parentId;

}
