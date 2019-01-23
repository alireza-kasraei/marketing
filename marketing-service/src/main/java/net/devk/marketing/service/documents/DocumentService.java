package net.devk.marketing.service.documents;

import org.springframework.web.multipart.MultipartFile;

import net.devk.marketing.service.model.CustomerDocument;

public interface DocumentService {

	public CustomerDocument createCustomerDocument(Long customerId, Long documentTypeId, MultipartFile file);

}
