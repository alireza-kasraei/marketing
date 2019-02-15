package net.devk.marketing.service;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

@Profile("jwt")
@Component
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
		OAuth2Authentication authentication = super.extractAuthentication(claims);
		authentication.setDetails(claims);
		return authentication;
	}

}