package net.devk.marketing.service.meetings;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.EntityNotFoundException;
import net.devk.marketing.service.contacts.ContactService;
import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.meetings.dto.CustomerMeetingListDTO;
import net.devk.marketing.service.meetings.dto.MeetingContactInfosDTO;
import net.devk.marketing.service.meetings.dto.MeetingQueryResultDTO;
import net.devk.marketing.service.meetings.dto.MeetingResultDTO;
import net.devk.marketing.service.model.ContactInfo;
import net.devk.marketing.service.model.Meeting;
import net.devk.marketing.service.model.MeetingResult;
import net.devk.marketing.service.util.MessageUtils;

@Service
class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;

	@Autowired
	private MeetingResultRepository meetingResultRepository;

	@Autowired
	private ContactService contactService;

	@Autowired
	private CustomerService customerService;

	@Override
	@Transactional
	public Meeting createMeeting(Long customerId, Date scheduleDate, String subject, Set<Long> contactInfoIds,
			Set<String> results) {
		Meeting meeting = new Meeting();
		meeting.setSubject(subject);
		meeting.setScheduleDate(scheduleDate);
		meeting.setCustomer(customerService.findOneCustomer(customerId));
		Set<ContactInfo> contactInfos = contactInfoIds.stream().map(id -> contactService.findOneContactInfo(id))
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

	@Transactional
	@Override
	public void updateMeeting(Long meetingId, Date scheduleDate, String subject) {
		meetingRepository.updateMeeting(meetingId, scheduleDate, subject);
	}

	@Override
	public Meeting findOneById(Long meetingId) {
		return meetingRepository.findById(meetingId).orElseThrow(
				() -> new EntityNotFoundException(MessageUtils.generateEntityNotFoundMessage(meetingId, "Meeting")));
	}

	@Transactional
	@Override
	public void addMeetingResult(Long meetingId, Set<String> results) {
		Meeting meeting = findOneById(meetingId);
		results.stream().map(s -> {
			MeetingResult meetingResult = new MeetingResult();
			meetingResult.setMeeting(meeting);
			meetingResult.setDescription(s);
			return meetingResult;
		}).forEach(m -> meetingResultRepository.save(m));
	}

	@Override
	public List<CustomerMeetingListDTO> findMeetings(Long customerId) {
		return meetingRepository.findMeetingsByCustomerId(customerId);
	}

	@Override
	public MeetingQueryResultDTO findMeetingById(Long meetingId) {
		MeetingQueryResultDTO meetingQueryResultDTO = meetingRepository.findOneMeeting(meetingId);
		List<MeetingResultDTO> meetingResults = meetingResultRepository.findMeetingResults(meetingId);
		List<MeetingContactInfosDTO> contactInfos = meetingRepository.findContactInfosByMeetingId(meetingId);
		meetingQueryResultDTO.setContactInfos(contactInfos);
		meetingQueryResultDTO.setMeetingResults(meetingResults);
		return meetingQueryResultDTO;
	}

}
