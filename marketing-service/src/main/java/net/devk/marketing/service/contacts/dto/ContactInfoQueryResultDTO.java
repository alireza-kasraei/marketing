package net.devk.marketing.service.contacts.dto;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactInfoQueryResultDTO {
	private final Long contactInfoId;
	private final String name;
	private final String roleName;
	private final List<ContactDetailInfoQueryResultDTO> details;

}
