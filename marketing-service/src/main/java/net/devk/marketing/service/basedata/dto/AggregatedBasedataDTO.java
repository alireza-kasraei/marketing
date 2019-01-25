package net.devk.marketing.service.basedata.dto;

import java.util.List;

import lombok.Data;

/**
 * Aggregated Type for all base data
 */
@Data
public class AggregatedBasedataDTO {

	private final List<BasedataDTO> valueTypes;
	private final List<BasedataDTO> businessScales;
	private final List<BasedataDTO> contactRoles;
	private final List<BasedataDTO> attractionTypes;
	private final List<BasedataDTO> documentTypes;
	private final List<BasedataDTO> requirementStatusTypes;
	private final List<BasedataDTO> assignStatusTypes;
	private final List<BasedataDTO> ownershipTypes;
	private final List<BasedataDTO> organizationTypes;
	private final List<ContactTypeDTO> contactTypes;
	private final List<ServiceDTO> services;

}
