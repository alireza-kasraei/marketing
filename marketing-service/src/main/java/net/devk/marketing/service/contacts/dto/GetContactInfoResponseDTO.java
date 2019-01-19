package net.devk.marketing.service.contacts.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetContactInfoResponseDTO {
	private Long contactInfoId;
	private String name;
	private String roleName;
	private List<ContactDetailInfoQueryResultDTO> details;

}
