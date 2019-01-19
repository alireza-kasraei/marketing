package net.devk.marketing.service.documents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNewCustomerDocumentRequestDTO {

	private String documentName;
	private Long documentTypeId;

}
