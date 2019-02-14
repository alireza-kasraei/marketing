package net.devk.marketing.service.meetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.meetings.dto.AddNewMeetingResults;
import net.devk.marketing.service.meetings.dto.UpdateMeetingRequestDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "meetings/")
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	@RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateMeeting(@RequestBody UpdateMeetingRequestDTO updateMeetingRequestDTO,
			@PathVariable(name = "id", required = true) Long meetingId) {
		meetingService.updateMeeting(meetingId, updateMeetingRequestDTO.getScheduleDate(),
				updateMeetingRequestDTO.getSubject(), updateMeetingRequestDTO.getContactInfoIds());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(path = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findMeeting(@PathVariable(name = "id", required = true) Long meetingId) {
		return ResponseEntity.ok(meetingService.findMeetingById(meetingId));
	}

	@RequestMapping(path = "{id}/results", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addMeetingResults(@RequestBody AddNewMeetingResults addNewMeetingResults,
			@PathVariable(name = "id", required = true) Long meetingId) {
		meetingService.addMeetingResult(meetingId, addNewMeetingResults.getResults());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(path = "{id}/results", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findMeetingResults(@PathVariable(name = "id", required = true) Long meetingId) {
		return ResponseEntity.ok(meetingService.findMeetingResultsByMeetingId(meetingId));
	}

}
