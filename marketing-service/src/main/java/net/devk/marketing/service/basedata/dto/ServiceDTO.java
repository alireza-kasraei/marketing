package net.devk.marketing.service.basedata.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ServiceDTO {

	private final Long id;
	private final String name;
	private final Long parentId;

}
