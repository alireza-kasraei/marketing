package net.devk.marketing.service.targets;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.targets.dto.PersonnelTargetsListResponseDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/targets")
public class TargetController {

	@Autowired
	private TargetService targetService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonnelTargetsListResponseDTO>> findAll(Principal principal) {
		return ResponseEntity.ok(targetService.findTargets(principal.getName()));
	}

}
