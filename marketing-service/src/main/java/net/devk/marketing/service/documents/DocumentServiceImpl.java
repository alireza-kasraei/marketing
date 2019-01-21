package net.devk.marketing.service.documents;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	@Transactional
	public CustomerDocument createCustomerDocument(Long customerId, String documentName, Long documentTypeId,
			MultipartFile file) {
		CustomerDocument customerDocument = new CustomerDocument();
		customerDocument.setCustomer(customerService.getOneCustomer(customerId));
		customerDocument.setDocumentName(documentName);
		customerDocument.setDocumentType(basedataService.getOneDocumentType(documentTypeId));
		// customerDocument.setFilePath(File.createTempFile(null, ""));
		return customerDocumentRepository.save(customerDocument);
	}

}
