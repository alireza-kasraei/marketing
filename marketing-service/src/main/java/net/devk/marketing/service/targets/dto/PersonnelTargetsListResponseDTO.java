package net.devk.marketing.service.targets.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonnelTargetsListResponseDTO {

	private final Long targetId;
	private final Long targetValue;
	private final String targetName;
	private final Long targetMemberId;
	private final Long targetMemberValue;
	private final String targetMemberName;
	private final String serviceName;
	private final Long serviceId;

}
