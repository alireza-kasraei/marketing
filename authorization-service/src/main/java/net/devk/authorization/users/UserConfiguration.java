package net.devk.authorization.users;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserConfiguration {

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Bean
	UserDetailsService userDetailsService(UserRepository userRepository) {
		return username -> userRepository.findByUsername(username).map(user -> {
			Set<String> roles = userRepository.findRoles(username);
			return User.withUsername(user.getUsername()).password(user.getPassword())
					.roles(roles.toArray(new String[roles.size()])).disabled(!user.isEnabled())
					.accountLocked(user.isLocked()).build();
			// .passwordEncoder(p -> passwordEncoder.encode(p))
		}).orElseThrow(() -> new UsernameNotFoundException(String.format("username %s not found!", username)));
	}
}
