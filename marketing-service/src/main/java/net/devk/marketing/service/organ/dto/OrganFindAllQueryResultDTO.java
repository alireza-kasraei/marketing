package net.devk.marketing.service.organ.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrganFindAllQueryResultDTO {

	private final Long id;
	private final String name;
	private final Integer level;
	private final Integer order;
	private final Long parentId;

}
