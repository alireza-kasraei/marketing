package net.devk.marketing.service.customers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNewCustomerRequestDTO {
	
	private final String name;
	private final Long businessScaleId;
	private final Long customerTypeId;
	private final String economicSection;
	private final String latitude;
	private final String longitude;
	private final String address;

}
