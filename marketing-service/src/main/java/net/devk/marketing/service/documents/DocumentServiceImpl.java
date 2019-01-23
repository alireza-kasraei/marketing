package net.devk.marketing.service.documents;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.IOUtils;
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
	public CustomerDocument createCustomerDocument(Long customerId, Long documentTypeId, MultipartFile file) {

		CustomerDocument customerDocument = new CustomerDocument();
		customerDocument.setRegisterDate(new Date());
		customerDocument.setCustomer(customerService.getOneCustomer(customerId));
		customerDocument.setDocumentName(file.getOriginalFilename());
		customerDocument.setDocumentType(basedataService.getOneDocumentType(documentTypeId));
//		try {
//			customerDocument.setFile(IOUtils.toByteArray(file.getInputStream()));
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
		return customerDocumentRepository.save(customerDocument);
	}

}
