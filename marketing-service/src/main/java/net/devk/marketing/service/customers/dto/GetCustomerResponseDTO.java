package net.devk.marketing.service.customers.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.devk.marketing.service.model.RegistrationStatus;

@Data
@AllArgsConstructor
public class GetCustomerResponseDTO {

	private final Long id;
	private final String name;
	private final Date registerDate;
	private final Boolean legal;
	private final String economicCode;
	private final Integer headCount;
	private final Long annualIncome;
	private final Boolean hasDocument;
	private final RegistrationStatus registrationStatus;
	private final String username;

	private final Long businessScaleId;
	private final String businessScaleName;

	private final Long customerTypeId;
	private final String customerTypeName;
	private final Long ownershipTypeId;
	private final String ownershipType;

	private final Long attractionTypeId;
	private final String attractionTypeName;

}
