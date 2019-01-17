package net.devk.marketing.service;


import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecureGreetingsRestController {

	@PreAuthorize("#oauth2.hasScope('openid')")
	@RequestMapping(method = RequestMethod.GET, value = "/greet/{name}")
	Map<String, String> hi(@PathVariable String name, Principal p) {
		return Collections.singletonMap("greeting", "Hello, " + name + " from " + p.getName() + "!");
	}
}