package net.devk.marketing.service.charts;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.targets.TargetService;
import net.devk.marketing.service.targets.dto.AggregateTargetResponseDTO;
import net.devk.marketing.service.targets.dto.TargetMemberQueryResultDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/charts")
public class ChartController {

	@Autowired
	private TargetService targetService;

	@RequestMapping(path = "/personnel-targets", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TargetMemberQueryResultDTO>> findPersonnelTargets(
			@RequestParam(name = "serviceId", required = true) Long serviceId, Principal principal) {
		return ResponseEntity.ok(targetService.findPersonnelTargets(principal.getName(), serviceId));
	}

	@RequestMapping(path = "/target-statistics", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AggregateTargetResponseDTO> getTargetStatistics(
			@RequestParam(name = "targetId", required = true) Long targetId) {
		return ResponseEntity.ok(targetService.calculateTargetStatistics(targetId));
	}

	@RequestMapping(path = "/target-member-statistics", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AggregateTargetResponseDTO> getTargetMemberStatistics(
			@RequestParam(name = "targetMemberId", required = true) Long targeMembertId) {
		return ResponseEntity.ok(targetService.calculateTargetMemberStatistics(targeMembertId));
	}

}
