package net.devk.marketing.service.meetings.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MeetingContactInfosDTO {

	private final Long meetingId;
	private final Long id;
	private final Long contactRoleId;
	private final String contactName;

}
