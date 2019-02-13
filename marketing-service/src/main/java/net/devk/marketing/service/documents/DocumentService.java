package net.devk.marketing.service.documents;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import net.devk.marketing.service.documents.dto.CustomerDocumentListDTO;
import net.devk.marketing.service.model.CustomerDocument;

public interface DocumentService {

	public CustomerDocument createCustomerDocument(Long customerId, Long documentTypeId, MultipartFile file);

	public Resource retrieveDocument(Long customerId, String fileName);

	public List<CustomerDocumentListDTO> getFiles(Long customerId);

}
