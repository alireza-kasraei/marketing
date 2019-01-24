package net.devk.marketing.service.requirements.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateNewRequirementRequestDTO {

	private final Long targetMemberId;
	private final Integer estimatedValue;
	private final String description;

}
