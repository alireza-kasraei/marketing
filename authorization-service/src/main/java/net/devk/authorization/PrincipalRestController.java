package net.devk.authorization;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.devk.authorization.model.User;
import net.devk.authorization.users.UserService;

/**
 * Controller for retrieving user's principle object from oauth token
 */
@RestController
@RequestMapping("/secured")
public class PrincipalRestController {

	private final UserService userService;

	public PrincipalRestController(UserService userService) {
		super();
		this.userService = userService;
	}

	@Secured({ "ROLE_USER" })
	@GetMapping("/user")
	public Principal principal(Principal p) {
		return p;
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/user-info")
	public ResponseEntity<?> userInfo(Principal p) {
		if (p == null)
			return ResponseEntity.notFound().build();
		final String name = p.getName();
		User user = userService.findByUsername(name).orElseThrow(RuntimeException::new);

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
