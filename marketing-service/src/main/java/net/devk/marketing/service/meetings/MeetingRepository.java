package net.devk.marketing.service.meetings;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.devk.marketing.service.model.Meeting;

interface MeetingRepository extends JpaRepository<Meeting, Long> {

	@Modifying
	@Query("update Meeting m set m.scheduleDate=?2,m.subject=?3 where m.id=?1")
	public int updateMeeting(Long meetingId,Date scheduleDate, String subject);

}
