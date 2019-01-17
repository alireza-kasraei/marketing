package net.devk.marketing.service;


import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicGreetingsRestController {

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/greet/{name}")
	Map<String, String> hi(@PathVariable String name, HttpServletRequest request) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> keySet = parameterMap.keySet();
		for (String key : keySet) {
			String[] parameters = parameterMap.get(key);
			for (String parameter : parameters) {
				System.out.println(String.format("Query parameter = %s , value = %s", key, parameter));
			}
		}
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			System.out.println(String.format("header = %s , value = %s", header, request.getHeader(header)));
			
		}

		return Collections.singletonMap("greeting", "Hello, " + name);
	}
}