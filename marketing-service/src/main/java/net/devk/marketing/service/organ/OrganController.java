package net.devk.marketing.service.organ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.organ.dto.OrganFindAllQueryResultDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/organs")
public class OrganController {

	@Autowired
	private OrganService organService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrganFindAllQueryResultDTO>> findOrgans() {
		return ResponseEntity.status(HttpStatus.OK).body(organService.findAllOrgans());
	}

}
