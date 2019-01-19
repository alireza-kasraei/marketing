package net.devk.marketing.service.customers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCustomerRequestDTO {

	private final Long companyTypeId;
	private final Integer headCount;
	private final Long ownershipTypeId;
	private final Long annualIncome;

}
