package net.devk.marketing.service.charts.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonnelTargetsResponseDTO {

	private Long targetId;
	private String targetValue;
	private Integer daysCount;
	private Integer targetMemberValue;

}
