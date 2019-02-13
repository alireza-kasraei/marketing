package net.devk.marketing.service.documents;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import net.devk.marketing.service.config.FileStorageProperties;

/**
 * File based implementation of {@link StorageService}
 */
@Service
public class FileStorageService implements StorageService {

	private final FileStorageProperties fileStorageProperties;

	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) {
		this.fileStorageProperties = fileStorageProperties;
	}

	@Override
	public String store(Long customerId, MultipartFile file) {

		Objects.requireNonNull(customerId);

		Path fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir(), customerId.toString())
				.toAbsolutePath().normalize();

		try {
			Files.createDirectories(fileStorageLocation);
		} catch (Exception ex) {
			throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
		}

		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return fileStorageLocation.getFileName().toString() + "/" + fileName;
		} catch (IOException ex) {
			throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	@Override
	public Resource retreive(Long customerId, String fileName) {
		Objects.requireNonNull(fileName);
		Path fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir(), customerId.toString())
				.toAbsolutePath().normalize();
		try {
			Path filePath = fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new FileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new FileNotFoundException("File not found " + fileName, ex);
		}
	}

	@Override
	public Resource retreive(String filePath) {
		Objects.requireNonNull(filePath);
		Path fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir(), filePath).toAbsolutePath()
				.normalize();
		try {
			Resource resource = new UrlResource(fileStorageLocation.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new FileNotFoundException("File not found " + filePath);
			}
		} catch (MalformedURLException ex) {
			throw new FileNotFoundException("File not found " + filePath, ex);
		}
	}

}
