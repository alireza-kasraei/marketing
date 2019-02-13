package net.devk.marketing.service.meetings;

import java.util.Date;
import java.util.List;
import java.util.Set;

import net.devk.marketing.service.meetings.dto.CustomerMeetingListDTO;
import net.devk.marketing.service.meetings.dto.MeetingQueryResultDTO;
import net.devk.marketing.service.model.Meeting;

public interface MeetingService {

	public Meeting findOneById(Long meetingId);

	/**
	 * @param meetingId
	 * @return DTO version of Meeting
	 */
	public MeetingQueryResultDTO findMeetingById(Long meetingId);

	public Meeting createMeeting(Long customerId, Date scheduleDate, String subject, Set<Long> contactInfoIds,
			Set<String> results);

	public void updateMeeting(Long meetingId, Date scheduleDate, String subject);

	public void addMeetingResult(Long meetingId, Set<String> results);

	public List<CustomerMeetingListDTO> findMeetings(Long customerId);

}
