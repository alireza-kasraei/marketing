package net.devk.marketing.service.meetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.customers.CustomerController;
import net.devk.marketing.service.meetings.dto.CreateNewMeetingRequestDTO;
import net.devk.marketing.service.meetings.dto.CreateNewMeetingResponseDTO;
import net.devk.marketing.service.model.Meeting;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + CustomerController.CUSTOMERS_ENDPOINT)
public class CustomerMeetingController {

	@Autowired
	private MeetingService meetingService;

	@RequestMapping(path = "{id}/meetings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateNewMeetingResponseDTO> createMeetings(
			@RequestBody CreateNewMeetingRequestDTO createNewMeetingRequestDTO,
			@PathVariable(name = "id", required = true) Long customerId) {

		Meeting meeting = meetingService.createMeeting(createNewMeetingRequestDTO.getScheduleDate(),
				createNewMeetingRequestDTO.getSubject(), createNewMeetingRequestDTO.getContactInfoIds(),
				createNewMeetingRequestDTO.getResults());
		return ResponseEntity.status(HttpStatus.CREATED).body(new CreateNewMeetingResponseDTO(meeting.getId()));
	}

}
