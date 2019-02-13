package net.devk.marketing.service.meetings.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MeetingQueryResultDTO {

	private final Long id;
	private final Date scheduleDate;
	private final String subject;
	private List<MeetingContactInfosDTO> contactInfos;
	private List<MeetingResultDTO> meetingResults;
	private final Long customerId;
	private final String customerName;

}
