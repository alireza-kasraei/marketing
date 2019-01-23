package net.devk.marketing.service.documents.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNewCustomerDocumentResponseDTO {

	private Long customerDocumentId;
	private Date registerDate;
	private String documentName;
	private Long documentTypeId;
	private Long customerId;

}
