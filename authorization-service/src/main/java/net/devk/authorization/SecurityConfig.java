package net.devk.authorization;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import net.devk.authorization.client.ClientService;
import net.devk.authorization.users.UserService;

@EnableResourceServer
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().formLogin().permitAll().and().authorizeRequests().anyRequest().authenticated().and()
				.httpBasic().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = "clientDetails")
	public ClientDetailsService clientDetailsService(ClientService clientService) {
		return name -> clientService.findByName(name).map(client -> {
			final String scopeNames = clientService.createClientScopeNames(name);
			List<String> autoApprovedScopeNames = clientService.findClientAutoApprovedScopeNames(name);
			final String authorities = clientService.createClientAuthorities(name);
			final String redirects = clientService.createClientRedirects(name);
			final String grantTypes = clientService.createClientGrantTypes(name);
			BaseClientDetails details = new BaseClientDetails(client.getName(), null, scopeNames, grantTypes,
					authorities, redirects);
			details.setClientSecret(client.getSecret());
			details.setAutoApproveScopes(autoApprovedScopeNames);
			return details;
		}).orElseThrow(() -> new ClientRegistrationException(String.format("no client %s registered", name)));
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
					.accountExpired(expireDate != null && expireDate.isAfter(LocalDate.now()))
					.credentialsExpired(credentialExpireDate != null && credentialExpireDate.isAfter(LocalDate.now()))
					.build();
			// .passwordEncoder(p -> passwordEncoder.encode(p))
		}).orElseThrow(() -> new UsernameNotFoundException(String.format("username %s not found!", username)));
	}

}