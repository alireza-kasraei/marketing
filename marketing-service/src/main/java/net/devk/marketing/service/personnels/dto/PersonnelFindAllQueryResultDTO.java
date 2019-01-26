package net.devk.marketing.service.personnels.dto;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonnelFindAllQueryResultDTO {

	private final Long id;
	private final String name;
	private final String username;
	private final Date registerDate;
	private final Long organId;

}
