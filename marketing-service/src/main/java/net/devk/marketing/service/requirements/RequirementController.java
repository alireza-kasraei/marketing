package net.devk.marketing.service.requirements;

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
import net.devk.marketing.service.requirements.dto.CreateNewAssignedRequirementRequestDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/requirements")
public class RequirementController {

	@Autowired
	private RequirementService requirementService;

	@RequestMapping(path = "/{id}/assign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> assignRequirement(
			@RequestBody CreateNewAssignedRequirementRequestDTO createNewAssignedRequirementRequestDTO,
			@PathVariable(name = "id", required = true) Long requirementId) {

		requirementService.assignRequirement(requirementId, createNewAssignedRequirementRequestDTO.getPersonnelId(),
				createNewAssignedRequirementRequestDTO.getAssigendStatusTypeId(),
				createNewAssignedRequirementRequestDTO.getRealValue());
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@RequestMapping(path = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAssignedRequirement(@PathVariable(name = "id",required = true) long customerId){
		return ResponseEntity.ok(requirementService.findAssignedRequirement(customerId));
	}



}
