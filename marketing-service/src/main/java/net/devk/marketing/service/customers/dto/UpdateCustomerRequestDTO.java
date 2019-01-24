package net.devk.marketing.service.customers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCustomerRequestDTO {

	private final String economicCode;
	private final Integer headCount;
	private final Long ownershipTypeId;
	private final Long organizationTypeId;
	private final Long annualIncome;

}
