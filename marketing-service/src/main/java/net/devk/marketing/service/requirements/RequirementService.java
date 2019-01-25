package net.devk.marketing.service.requirements;

import java.util.List;

import net.devk.marketing.service.requirements.dto.CreateNewRequirementRequestDTO;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementResponseDTO;

public interface RequirementService {

	public CreateNewRequirementResponseDTO createRequirement(Long customerId, Long targetMemberId, Long estimatedValue,
			String description);

	public List<CreateNewRequirementResponseDTO> createRequirement(Long customerId,
			List<CreateNewRequirementRequestDTO> list);

	public void assignRequirement(Long requirementId, Long personnelId, Long assignedStatusTypeId, Long realValue);

}
