package net.devk.marketing.service.requirements.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateRequirementRequestDTO {
	
	private Long requirementId;
	private Long personnelId;
	private Long realValue;
	private Long requirementStatusId;

}
