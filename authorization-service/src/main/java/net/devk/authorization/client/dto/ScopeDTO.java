package net.devk.authorization.client.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ScopeDTO {

	private final String scopeName;
	private final Boolean autoApproved;

}