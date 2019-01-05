package net.devk.greetingsservice;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicGreetingsRestController {

	@RequestMapping(method = RequestMethod.GET, value = "/greet/{name}")
	Map<String, String> hi(@PathVariable String name) {
		return Collections.singletonMap("greeting", "Hello, " + name);
	}
}