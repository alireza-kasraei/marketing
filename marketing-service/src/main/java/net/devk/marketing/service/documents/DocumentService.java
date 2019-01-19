package net.devk.marketing.service.documents;

import net.devk.marketing.service.model.CustomerDocument;

public interface DocumentService {

	public CustomerDocument createCustomerDocument(Long customerId, String documentName, Long documentId,
			byte[] contect);

}
