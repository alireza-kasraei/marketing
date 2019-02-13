package net.devk.marketing.service.documents.dto;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateNewCustomerDocumentResponseDTO {

	private final Long customerDocumentId;
	private final Date registerDate;
	private final String documentName;
	private final String path;
	private final Long documentTypeId;
	private final Long customerId;

}
