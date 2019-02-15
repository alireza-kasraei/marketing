package net.devk.marketing.service.documents;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import net.devk.marketing.service.documents.dto.CustomerDocumentResponseDTO;
import net.devk.marketing.service.model.CustomerDocument;

public interface DocumentService {

	public CustomerDocument createCustomerDocument(Long customerId, Long documentTypeId, String documentName,
			MultipartFile file);

	public Resource retrieveDocument(Long customerId, String fileName);

	public List<CustomerDocumentResponseDTO> createCustomerDocumentList(Long customerId);

	public String genereateFileUrl(String filePath);

}
