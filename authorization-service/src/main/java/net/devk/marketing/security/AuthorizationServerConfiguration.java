package net.devk.marketing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//@formatter:off
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
//@formatter:on

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private final AuthenticationManager authenticationManager;

	private final ClientDetailsService clientDetailsService;

	@Autowired
	public AuthorizationServerConfiguration(AuthenticationConfiguration authenticationConfiguration,
			@Qualifier("clientDetails") ClientDetailsService clientDetailsService) throws Exception {
		this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
		this.clientDetailsService = clientDetailsService;
	}

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.withClientDetails(clientDetailsService);

//		clients.inMemory().withClient("SampleClientId").secret(passwordEncoder.encode("secret"))
//				.authorizedGrantTypes("authorization_code", "refresh_token", "password").scopes("user_info")
//				.autoApprove(true).redirectUris("http://localhost:8082/ui/login", "http://localhost:8083/ui2/login",
//						"http://localhost:8082/login");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// <2>
		endpoints.authenticationManager(this.authenticationManager);
	}

}
