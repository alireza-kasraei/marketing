package net.devk.marketing.service.requirements.dto;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AggregatedCreateNewRequirementRequestDTO {

	/**
	 *  based on omid's request
	 */
	private final List<CreateNewRequirementRequestDTO> data;

}
