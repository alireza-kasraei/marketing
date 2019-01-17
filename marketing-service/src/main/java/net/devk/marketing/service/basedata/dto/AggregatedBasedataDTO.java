package net.devk.marketing.service.basedata.dto;

import java.util.List;

import lombok.Data;

@Data
public class AggregatedBasedataDTO {

	private List<BasedataDTO> valueTypes;
	private List<BasedataDTO> businessScales;
	private List<BasedataDTO> contactRoles;
	private List<ContactTypeDTO> contactTypes;
	private List<BasedataDTO> attractionTypes;
	private List<BasedataDTO> documentTypes;
	private List<BasedataDTO> requirementStatusTypes;
	private List<BasedataDTO> assignStatusTypes;
	private List<BasedataDTO> customerTypes;
	private List<BasedataDTO> ownershipTypes;

	private List<ServiceDTO> services;

}
