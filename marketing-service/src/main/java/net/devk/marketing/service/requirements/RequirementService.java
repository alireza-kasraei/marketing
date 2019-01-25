package net.devk.marketing.service.requirements;

import net.devk.marketing.service.requirements.dto.CreateNewRequirementResponseDTO;

public interface RequirementService {

	public CreateNewRequirementResponseDTO createRequirement(Long customerId, Long targetMemberId, Long estimatedValue,
			String description);
	
	public void assignRequirement(Long requirementId, Long personnelId , Long assignedStatusTypeId,Long realValue);

}
