package net.devk.marketing.service.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import net.devk.marketing.service.basedata.BasedataService;
import net.devk.marketing.service.customers.CustomerService;
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

		String path = storageService.store(customerId, file);

		CustomerDocument customerDocument = new CustomerDocument();
		customerDocument.setCustomer(customerService.getOneCustomer(customerId));
		customerDocument.setDocumentName(file.getOriginalFilename());
		customerDocument.setDocumentType(basedataService.getOneDocumentType(documentTypeId));
		customerDocument.setFilePath(path);
		return customerDocumentRepository.save(customerDocument);
	}

	@Override
	public Resource retrieveDocument(Long customerId, String fileName) {
		return storageService.retreive(customerId, fileName);
	}

}
