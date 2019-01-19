package net.devk.marketing.service.customers.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCustomerResponseDTO {
	
	private String name;
	private Long id;
	private Date regiserDate;
	private boolean legal;
	private String economicCode;

}
