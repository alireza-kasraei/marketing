package net.devk.marketing.service.documents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFileResponse {
	private final String fileName;
	private final String fileDownloadUri;
	private final String fileType;
	private final long size;
}