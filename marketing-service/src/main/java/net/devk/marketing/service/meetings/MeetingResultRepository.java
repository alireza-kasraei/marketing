package net.devk.marketing.service.meetings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.meetings.dto.MeetingResultDTO;
import net.devk.marketing.service.model.MeetingResult;

interface MeetingResultRepository extends JpaRepository<MeetingResult, Long> {

	@Query("select new net.devk.marketing.service.meetings.dto.MeetingResultDTO(mr.meeting.id,mr.id,mr.description) from MeetingResult mr where mr.meeting.id=?1")
	public List<MeetingResultDTO> findMeetingResults(Long meetingId);

}
