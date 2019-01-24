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
import net.devk.marketing.service.requirements.dto.CreateNewRequirementRequestDTO;
import net.devk.marketing.service.requirements.dto.CreateNewRequirementResponseDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/customers")
public class CustomerRequirementController {

	@Autowired
	private RequirementService requirementService;

	@RequestMapping(path = "/{id}/requirements", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateNewRequirementResponseDTO> createRequirement(
			@RequestBody CreateNewRequirementRequestDTO createNewRequirementRequestDTO,
			@PathVariable(name = "id", required = true) Long customerId) {

		return ResponseEntity.status(HttpStatus.CREATED).body(requirementService.createRequirement(
				customerId, createNewRequirementRequestDTO.getTargetMemberId(),
				createNewRequirementRequestDTO.getEstimatedValue(), createNewRequirementRequestDTO.getDescription()));
	}

}
