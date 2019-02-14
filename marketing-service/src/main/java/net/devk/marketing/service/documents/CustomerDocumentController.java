package net.devk.marketing.service.documents;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.documents.dto.CreateNewCustomerDocumentResponseDTO;
import net.devk.marketing.service.documents.dto.CustomerDocumentQueryResultDTO;
import net.devk.marketing.service.model.CustomerDocument;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/customers")
public class CustomerDocumentController {

	private Logger logger = LoggerFactory.getLogger(CustomerDocumentController.class);

	@Autowired
	private DocumentService documentService;

	@PostMapping("{id}/documents")
	public ResponseEntity<CreateNewCustomerDocumentResponseDTO> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("documentTypeId") Long documentTypeId, @PathVariable("id") Long customerId) {

		CustomerDocument customerDocument = documentService.createCustomerDocument(customerId, documentTypeId, file);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new CreateNewCustomerDocumentResponseDTO(customerDocument.getId(),
						customerDocument.getRegisterDate(), customerDocument.getDocumentName(),
						customerDocument.getFilePath(), customerDocument.getDocumentType().getId(), customerId));
	}

	@GetMapping("{id}/documents")
	public ResponseEntity<List<CustomerDocumentQueryResultDTO>> getFilesList(@PathVariable("id") Long customerId) {

//		List<CustomerDocumentQueryResultDTO> files = documentService.findCustomerDocumentByCustomerId(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@GetMapping("{id}/documents/{fileName}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long customerId,
			@PathVariable("fileName") String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = documentService.retrieveDocument(customerId, fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}
