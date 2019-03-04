package net.devk.marketing.service.requirements.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class AssignedRequirementFindAllDTO {
    /*private Long personnelId;
    private Long realValue;
    private Long assignedStatusTypeId;*/
    //TODO  whatever want to response
    private final Long requirementId;
    private final Long estimatedValue;
    private final Long realValue;
    private final String description;
    private final Date estimatedValueEditDate;
    private final Date estimatedValueRegisterDate;
    private final Date realValueEditDate;
    private final Date realValueRegisterDate;
    private final Long customerId;

    private final Long targetMemberId;
    private final Long targetMemberValue;

    private final Long targetId;
    private final Long targetValue;

    private final Long serviceId;
    private final String serviceName;
}
