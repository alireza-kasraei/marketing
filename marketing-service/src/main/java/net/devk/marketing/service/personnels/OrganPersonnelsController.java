package net.devk.marketing.service.personnels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.personnels.dto.PersonnelFindAllQueryResultDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX)
public class OrganPersonnelsController {

	@Autowired
	private PersonnelService personnelService;

	@RequestMapping(path = "/organs/{id}/personnels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonnelFindAllQueryResultDTO>> findPersonnelsByOrganId(
			@PathVariable(name = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(personnelService.findByOrganId(id));
	}

}
