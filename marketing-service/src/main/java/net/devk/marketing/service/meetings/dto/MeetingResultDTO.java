package net.devk.marketing.service.meetings.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MeetingResultDTO {

	private final Long meetingId;
	private final Long id;
	private final String description;

}
