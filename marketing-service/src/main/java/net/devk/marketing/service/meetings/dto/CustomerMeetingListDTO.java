package net.devk.marketing.service.meetings.dto;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomerMeetingListDTO {

	private final Long id;
	private final Date scheduleDate;
	private final String subject;
	private final Long customerId;

}
