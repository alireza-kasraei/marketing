package net.devk.marketing.service.documents.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomerDocumentResponseDTO {
	private final Long id;
	private final String documentName;
	private final String url;
	private final Long documentTypeId;
	private final String documentTypeName;
	private final Long customerId;
}
