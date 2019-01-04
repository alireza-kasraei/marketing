package net.devk.marketing.security;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PrincipalRestController {

	// <1>
	@RequestMapping("/user")
	Principal principal(Principal p) {
		return p;
	}

}
