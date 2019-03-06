package net.devk.marketing.service.requirements;

import net.devk.marketing.service.model.Requirement;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementRequestDTO;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementResponseDTO;
import net.devk.marketing.service.requirements.dto.CustomerRequirementResponseDTO;

import java.util.List;

public interface RequirementService {

    public CreateNewRequirementResponseDTO createRequirement(Long customerId, Long targetMemberId, Long estimatedValue,
                                                             String description);


    public List<CreateNewRequirementResponseDTO> createRequirement(Long customerId,
                                                                   List<CreateNewRequirementRequestDTO> list);

    public List<CustomerRequirementResponseDTO> findRequirements(Long customerId, String requirementStatusTypeCode);

    public void assignRequirement(Long requirementId, Long personnelId, Long assignedStatusTypeId, Long realValue);

    public void createSupplyRequirement(Long requirementId, String value, String supplyStatusCode);
    
    public Requirement findRequirement(long requirementId);

}
