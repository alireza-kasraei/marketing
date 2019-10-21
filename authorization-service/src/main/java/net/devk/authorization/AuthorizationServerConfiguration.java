package net.devk.authorization;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
//@formatter:off
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import net.devk.authorization.client.ClientService;

@Profile("identity")
@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class AuthorizationServerConfiguration {

	@Bean(name = "clientDetails")
	public ClientDetailsService clientDetailsService(ClientService clientService) {
		return name -> clientService.findByName(name).map(client -> {
			final String scopeNames = clientService.createClientScopeNames(name);
			if (scopeNames.isEmpty()) {
				throw new ClientRegistrationException(String.format("client %s does not have any scopes", name));
			}
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

	@Configuration
	@Profile("!jwt")
	public class NoJwtServerConfiguration extends AuthorizationServerConfigurerAdapter {

		private final AuthenticationManager authenticationManager;
		private final ClientDetailsService clientDetailsService;
		private final RedisConnectionFactory redisConnectionFactory;
		private final PasswordEncoder passwordEncoder;

		@Autowired
		public NoJwtServerConfiguration(AuthenticationConfiguration authenticationConfiguration,
				@Qualifier("clientDetails") ClientDetailsService clientDetailsService,
				RedisConnectionFactory redisConnectionFactory, PasswordEncoder passwordEncoder) throws Exception {
			this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
			this.clientDetailsService = clientDetailsService;
			this.redisConnectionFactory = redisConnectionFactory;
			this.passwordEncoder = passwordEncoder;
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
					.passwordEncoder(passwordEncoder);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.withClientDetails(clientDetailsService);
		}

		@Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
			defaultTokenServices.setTokenStore(tokenStore());
			defaultTokenServices.setSupportRefreshToken(true);
			return defaultTokenServices;
		}

		@Override
		public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
			tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
			endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain)
					.authenticationManager(authenticationManager);
		}

		@Bean
		public TokenStore tokenStore() {
			return new RedisTokenStore(redisConnectionFactory);
		}

		@Bean
		public TokenEnhancer tokenEnhancer() {
			return new CustomTokenEnhancer();
		}

	}

	@Configuration
	@Profile("jwt")
	public class JwtServerConfiguration extends AuthorizationServerConfigurerAdapter {
		private final AuthenticationManager authenticationManager;
		private final ClientDetailsService clientDetailsService;
		private final PasswordEncoder passwordEncoder;

		@Autowired
		public JwtServerConfiguration(AuthenticationConfiguration authenticationConfiguration,
				@Qualifier("clientDetails") ClientDetailsService clientDetailsService, PasswordEncoder passwordEncoder)
				throws Exception {
			this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
			this.clientDetailsService = clientDetailsService;
			this.passwordEncoder = passwordEncoder;
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
					.passwordEncoder(passwordEncoder);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.withClientDetails(clientDetailsService);
		}

		@Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
			defaultTokenServices.setTokenStore(tokenStore());
			defaultTokenServices.setSupportRefreshToken(true);
			return defaultTokenServices;
		}

		@Override
		public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
			// this is for jwt
			tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));
			endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain)
					.authenticationManager(authenticationManager);
		}

		@Bean
		public TokenStore tokenStore() {
			return new JwtTokenStore(accessTokenConverter());
		}

		@Bean
		public JwtAccessTokenConverter accessTokenConverter() {
			final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
			converter.setSigningKey("123");
			// signed with a key
			/*
			 * final KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new
			 * ClassPathResource("mytest.jks"), "mypass".toCharArray());
			 * converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest"));
			 */
			return converter;
		}

		@Bean
		public TokenEnhancer tokenEnhancer() {
			return new CustomTokenEnhancer();
		}
	}

}
