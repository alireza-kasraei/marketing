package net.devk.marketing.service.documents;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService implements StorageService {
	
	

	@Override
	public String store(Long customerId, MultipartFile file) {
		return null;
	}

}
