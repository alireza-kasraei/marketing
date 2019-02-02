package net.devk.marketing.service.documents;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	public Path store(Long customerId, MultipartFile file);

}
