package net.devk.marketing.service.requirements.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateNewAssignedRequirementRequestDTO {

	private Long personnelId;
	private Integer realValue;
	private Long assigendStatusTypeId;

}
