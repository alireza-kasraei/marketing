package net.devk.marketing.service.customers.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateNewCustomerRequestDTO {

	private final String name;
	private final Long businessScaleId;
	private final boolean legal;
	private final String economicSection;
	private final String latitude;
	private final String longitude;
	private final String address;

}
