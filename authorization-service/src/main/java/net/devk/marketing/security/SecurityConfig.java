package net.devk.marketing.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception { // @formatter:off
		http.requestMatchers().antMatchers("/login", "/oauth/authorize").and().authorizeRequests().anyRequest()
				.authenticated().and().formLogin().permitAll().and().httpBasic().disable();
	} // @formatter:on

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
//		auth.inMemoryAuthentication().withUser("john").password(passwordEncoder().encode("123")).roles("USER");
//	} 
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}