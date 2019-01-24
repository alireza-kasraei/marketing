package net.devk.marketing.service.requirements.dto;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateNewRequirementResponseDTO {

	private final Long id;
	private final Integer estimatedValue;
	private final Integer realValue;
	private final String description;
	private final Date estimatedValueEditDate;
	private final Date estimatedValueRegisterDate;
	private final Date realValueEditDate;
	private final Date realValueRegisterDate;

}
