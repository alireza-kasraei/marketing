package net.devk.marketing.service.basedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;
import net.devk.marketing.service.basedata.dto.AggregatedBasedataDTO;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + BasedataController.BASEDATA)
public class BasedataController {

	public static final String BASEDATA = "/basedata";

	@Autowired
	private BasedataService basedataService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AggregatedBasedataDTO> getAggregatedBasedata() {
		return ResponseEntity.ok(basedataService.getAggregatedBasedata());
	}

}
