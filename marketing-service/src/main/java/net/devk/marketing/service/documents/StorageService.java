package net.devk.marketing.service.documents;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	public String store(Long customerId, MultipartFile file);

}
