package net.devk.marketing.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//@formatter:off
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private final AuthenticationManager authenticationManager;

	private final ClientDetailsService clientDetailsService;

	private final RedisConnectionFactory redisConnectionFactory;

	@Autowired
	public AuthorizationServerConfiguration(AuthenticationConfiguration authenticationConfiguration,
			@Qualifier("clientDetails") ClientDetailsService clientDetailsService,
			RedisConnectionFactory redisConnectionFactory) throws Exception {
		this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
		this.clientDetailsService = clientDetailsService;
		this.redisConnectionFactory = redisConnectionFactory;
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

//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.authenticationManager(this.authenticationManager);
//	}

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
//		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));

		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
		endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain)
				.authenticationManager(authenticationManager);
	}

	@Bean
	public TokenStore tokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}

	/*
	 * @Bean public TokenStore tokenStore() { return new
	 * JwtTokenStore(accessTokenConverter()); }
	 * 
	 * @Bean public JwtAccessTokenConverter accessTokenConverter() { final
	 * JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	 * converter.setSigningKey("123"); // final KeyStoreKeyFactory
	 * keyStoreKeyFactory = new KeyStoreKeyFactory(new //
	 * ClassPathResource("mytest.jks"), "mypass".toCharArray()); //
	 * converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest")); return
	 * converter; }
	 */
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}

}
