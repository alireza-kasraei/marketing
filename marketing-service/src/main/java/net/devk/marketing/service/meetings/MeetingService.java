package net.devk.marketing.service.meetings;

import java.util.Date;
import java.util.Set;

import net.devk.marketing.service.model.Meeting;

public interface MeetingService {

	public Meeting createMeeting(Date scheduleDate, String subject, Set<Long> contactInfoIds, Set<String> results);

}
