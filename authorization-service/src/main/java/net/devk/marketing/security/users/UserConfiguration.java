package net.devk.marketing.security.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

@Configuration
public class UserConfiguration {

	@Bean
	UserDetailsService userDetailsService(UserRepository accountRepository) {
		return username -> accountRepository.findByUsername(username).map(account -> {
			final boolean active = account.isActive();
			final String roles = account.getRoles();
			return User.withUsername(account.getUsername()).password("{noop}" + account.getPassword())
					.roles(StringUtils.commaDelimitedListToStringArray(roles)).disabled(!active).accountLocked(!active)
					.build();
		}).orElseThrow(() -> new UsernameNotFoundException(String.format("username %s not found!", username)));
	}
}
