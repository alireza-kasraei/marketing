package net.devk.marketing.security.clients;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

@Configuration
public class ClientConfiguration {

	@Bean(name = "clientDetails")
	ClientDetailsService clientDetailsService(ClientRepository clientRepository) {
		return clientId -> clientRepository.findByClientId(clientId).map(client -> {

			String scopes = clientRepository.findScopes(clientId).orElseGet(() -> new ArrayList<String>()).stream()
					.collect(Collectors.joining(","));

			BaseClientDetails details = new BaseClientDetails(client.getClientId(), null, scopes,
					client.getAuthorizedGrantTypes(), client.getAuthorities(), client.getRedirectUrls());
			details.setClientSecret("{noop}" + client.getSecret());

			// details.setAutoApproveScopes
			// (Arrays.asList(client.getAutoApproveScopes().split(",")));

//			String greetingsClientRedirectUri = Optional.ofNullable(this.loadBalancerClient.choose("api-service"))
//					.map(si -> "http://" + si.getHost() + ':' + si.getPort() + '/').orElseGet(() -> "");

			return details;
		}).orElseThrow(() -> new ClientRegistrationException(String.format("no client %s registered", clientId)));
	}
}
