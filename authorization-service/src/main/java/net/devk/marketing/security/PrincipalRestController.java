package net.devk.marketing.security;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.devk.marketing.security.model.User;
import net.devk.marketing.security.users.UserRepository;

/**
 * Controller for retrieving user's principle object from oauth token
 */
@RestController
class PrincipalRestController {

	private final UserRepository userRepository;

	public PrincipalRestController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@RequestMapping("/user")
	Principal principal(Principal p) {
		return p;
	}

	@RequestMapping("/user-info")
	ResponseEntity<?> userInfo(Principal p) {
		if (p == null)
			return ResponseEntity.notFound().build();
		final String name = p.getName();
		User user = userRepository.findByUsername(name).get();
		// keep it simple
		Map<String, String> userMap = new HashMap<>();
		userMap.put("username", user.getUsername());
		userMap.put("mobileNumber", user.getMobileNumber());
		userMap.put("email", user.getEmail());
		userMap.put("firstname", user.getFirstName());
		userMap.put("lastname", user.getLastName());
		return ResponseEntity.ok(userMap);
	}

}
