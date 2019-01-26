package net.devk.marketing.service.organ.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateNewOrganRequestDTO {

	private final String name;
	private final Integer level;
	private final Integer order;

	private final Long parentId;

}
