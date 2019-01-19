package net.devk.marketing.service.documents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.devk.marketing.service.ControllersConfig;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/customers")
public class CustomerDocumentController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDocumentController.class);

	@Autowired
	private DocumentService documentService;

	@PostMapping("{id}/documents")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("id") Long customerId) {

//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());

		logger.info(String.format("filename : %s", file.getOriginalFilename()));
		return ResponseEntity.ok().build();
	}

}
