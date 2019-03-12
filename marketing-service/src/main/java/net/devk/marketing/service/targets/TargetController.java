package net.devk.marketing.service.targets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + TargetController.TARGETS_ENDPOINT)
public class TargetController {

	static final String TARGETS_ENDPOINT = "/targets";
	@Autowired
	private TargetService targetService;

}
