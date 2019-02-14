package net.devk.marketing.service.documents;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.documents.dto.CustomerDocumentQueryResultDTO;
import net.devk.marketing.service.documents.dto.CustomerDocumentResponseDTO;
import net.devk.marketing.service.model.CustomerDocument;

@Service
class DocumentServiceImpl implements DocumentService {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerDocumentRepository customerDocumentRepository;
	@Autowired
	private BasedataService basedataService;
	@Autowired
	private StorageService storageService;

	@Override
	@Transactional
	public CustomerDocument createCustomerDocument(Long customerId, Long documentTypeId, MultipartFile file) {

		CustomerDocument customerDocument = new CustomerDocument();
		customerDocument.setCustomer(customerService.findOneCustomer(customerId));
		customerDocument.setDocumentName(file.getOriginalFilename());
		customerDocument.setDocumentType(basedataService.findOneDocumentType(documentTypeId));
		String path = storageService.store(customerId, file);
		customerDocument.setFilePath(path);
		return customerDocumentRepository.save(customerDocument);
	}

	@Override
	public Resource retrieveDocument(Long customerId, String fileName) {
		return storageService.retreive(customerId, fileName);
	}

	@Override
	public List<CustomerDocumentResponseDTO> findCustomerDocumentByCustomerId(Long customerId) {
		List<CustomerDocumentQueryResultDTO> customerDocuments = customerDocumentRepository
				.findDocumentsByCustomerId(customerId);
		return customerDocuments.stream().map(cd -> {
			return new CustomerDocumentResponseDTO(cd.getId(), cd.getDocumentName(), cd.getFilePath(),
					cd.getDocumentTypeId(), cd.getDocumentName(), cd.getCustomerId());
		}).collect(Collectors.toList());
	}

}
