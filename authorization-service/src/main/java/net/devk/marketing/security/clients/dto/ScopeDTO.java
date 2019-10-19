package net.devk.marketing.security.clients.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ScopeDTO {

	private final String scopeName;
	private final Boolean autoApproved;

}