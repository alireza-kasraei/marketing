package net.devk.marketing.service.requirements;

import net.devk.marketing.service.requirements.dto.CreateNewRequirementResponseDTO;

public interface RequirementService {

	public CreateNewRequirementResponseDTO createRequirement(Long customerId, Long targetMemberId, Integer estimatedValue,
			String description);

}
