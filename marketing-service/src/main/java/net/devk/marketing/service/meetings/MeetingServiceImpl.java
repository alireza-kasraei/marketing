package net.devk.marketing.service.meetings;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.contacts.ContactService;
import net.devk.marketing.service.model.ContactInfo;
import net.devk.marketing.service.model.Meeting;
import net.devk.marketing.service.model.MeetingResult;

@Service
class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;

	@Autowired
	private MeetingResultRepository meetingResultRepository;

	@Autowired
	private ContactService contactService;

	@Override
	@Transactional
	public Meeting createMeeting(Date scheduleDate, String subject, Set<Long> contactInfoIds, Set<String> results) {
		Meeting meeting = new Meeting();
		meeting.setSubject(subject);
		meeting.setScheduleDate(scheduleDate);
		Set<ContactInfo> contactInfos = contactInfoIds.stream().map(id -> contactService.getOneContactInfo(id))
				.collect(Collectors.toSet());
		meeting.getContactInfos().addAll(contactInfos);
		final Meeting savedMeeting = meetingRepository.save(meeting);

		results.stream().map(s -> {
			MeetingResult meetingResult = new MeetingResult();
			meetingResult.setMeeting(savedMeeting);
			meetingResult.setDescription(s);
			return meetingResult;
		}).forEach(m -> meetingResultRepository.save(m));

		return savedMeeting;
	}

}
