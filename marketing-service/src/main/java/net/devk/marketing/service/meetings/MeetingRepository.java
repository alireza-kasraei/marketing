package net.devk.marketing.service.meetings;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.meetings.dto.CustomerMeetingListDTO;
import net.devk.marketing.service.meetings.dto.MeetingContactInfosDTO;
import net.devk.marketing.service.meetings.dto.MeetingQueryResultDTO;
import net.devk.marketing.service.model.Meeting;

interface MeetingRepository extends JpaRepository<Meeting, Long> {

	@Modifying
	@Query("update Meeting m set m.scheduleDate=?2,m.subject=?3 where m.id=?1")
	public int updateMeeting(Long meetingId, Date scheduleDate, String subject);

	@Query("select new net.devk.marketing.service.meetings.dto.CustomerMeetingListDTO(m.id,m.scheduleDate,m.subject,m.customer.id) from Meeting m where m.customer.id=?1")
	public List<CustomerMeetingListDTO> findMeetingsByCustomerId(Long customerId);

	@Query("select new net.devk.marketing.service.meetings.dto.MeetingQueryResultDTO(m.id,m.scheduleDate,m.subject,c.id,c.name) from Meeting m inner join m.customer c where m.id=?1")
	public Optional<MeetingQueryResultDTO> findOneMeeting(Long meetingId);

	@Query("select new net.devk.marketing.service.meetings.dto.MeetingContactInfosDTO(m.id,c.id,c.role.id,c.name) from Meeting m inner join m.contactInfos c where m.id=?1")
	public List<MeetingContactInfosDTO> findContactInfosByMeetingId(Long meetingId);

}
