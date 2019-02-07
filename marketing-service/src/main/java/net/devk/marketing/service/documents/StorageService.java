package net.devk.marketing.service.documents;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service for storing and retrieving contents of uploaded resources. this can
 * be a FileSystem , FTP , ...
 */
public interface StorageService {

	public String store(Long customerId, MultipartFile file);

	public Resource retreive(Long customerId, String fileName);

}
