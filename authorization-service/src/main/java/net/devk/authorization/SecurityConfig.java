package net.devk.authorization;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.devk.authorization.users.UserService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/login", "/oauth/authorize").and().authorizeRequests().anyRequest()
				.authenticated().and().formLogin().permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(UserService userService) {
		return username -> userService.findByUsername(username).map(user -> {
			final Boolean enabled = user.getEnabled();
			final Boolean locked = user.getLocked();
			final LocalDate expireDate = user.getExpireDate();
			final LocalDate credentialExpireDate = user.getCredentialExpireDate();
			Set<String> roles = userService.findRoles(username);
			return User.withUsername(user.getUsername()).password(user.getPassword())
					.roles(roles.toArray(new String[roles.size()])).disabled(enabled != null && !enabled.booleanValue())
					.accountLocked(locked != null && locked.booleanValue())
					.accountExpired(expireDate != null && expireDate.isBefore(LocalDate.now()))
					.credentialsExpired(credentialExpireDate != null && credentialExpireDate.isBefore(LocalDate.now()))
					.build();
			// .passwordEncoder(p -> passwordEncoder.encode(p))
		}).orElseThrow(() -> new UsernameNotFoundException(String.format("username %s not found!", username)));
	}

}