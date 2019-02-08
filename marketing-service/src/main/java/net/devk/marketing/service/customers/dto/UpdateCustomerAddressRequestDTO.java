package net.devk.marketing.service.customers.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateCustomerAddressRequestDTO {

	private final String address;
	private final String latitude;
	private final String longitude;

}
