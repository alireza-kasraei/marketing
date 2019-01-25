package net.devk.marketing.service.targets.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TargetMemberQueryResultDTO {

	private final Long targetId;
	private final Long targetValue;
	private final Integer daysCount;
	private final Long targetMemberValue;

}
