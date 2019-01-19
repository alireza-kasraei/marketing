package net.devk.marketing.service.meetings.dto;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNewMeetingRequestDTO {

	private final String subject;
	private final Date scheduleDate;
	private final Set<Long> contactInfoIds;
	private final Set<String> results;

}
