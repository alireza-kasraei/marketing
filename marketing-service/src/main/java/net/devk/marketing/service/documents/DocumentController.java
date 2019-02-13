package net.devk.marketing.service.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.service.ControllersConfig;

@RestController
@RequestMapping(path = ControllersConfig.API_PREFIX + "/documents")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

}
