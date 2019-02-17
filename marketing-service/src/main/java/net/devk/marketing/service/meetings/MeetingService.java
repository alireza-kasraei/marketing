package net.devk.marketing.service.meetings;

import java.util.Date;
import java.util.List;
import java.util.Set;

import net.devk.marketing.service.meetings.dto.CustomerMeetingListDTO;
import net.devk.marketing.service.meetings.dto.MeetingQueryResultDTO;
import net.devk.marketing.service.meetings.dto.MeetingResultDTO;
import net.devk.marketing.service.model.Meeting;

/**
 * all JPA Wrapper find* Methods have findEntityName* structure. other methods
 * which returns a DTO do not have any restriction or constraint on their
 * naming.
 */
public interface MeetingService {

	/**
	 * @param meetingId
	 * @return {@link Meeting}
	 */
	public Meeting findMeetingEntityById(Long meetingId);

	/**
	 * @param meetingId
	 * @return DTO version of Meeting
	 */
	public MeetingQueryResultDTO findMeetingById(Long meetingId);

	public Meeting createMeeting(Long customerId, Date scheduleDate, String subject, Set<Long> contactInfoIds,
			Set<String> results);

	public void updateMeeting(Long meetingId, Date scheduleDate, String subject, Set<Long> contactInfoIds);

	public void updateMeetingResult(Long meetingId, Set<String> results);

	public List<CustomerMeetingListDTO> findMeetingsByCustomerId(Long customerId);

	public List<MeetingResultDTO> findMeetingResultsByMeetingId(Long meetingId);

}
