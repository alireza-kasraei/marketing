package net.devk.marketing.service.meetings.dto;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateMeetingRequestDTO {

	private final String subject;
	private final Date scheduleDate;

}
