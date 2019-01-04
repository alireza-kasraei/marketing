package net.devk.marketing.security.clients;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

@Configuration
public class ClientConfiguration {

	private final LoadBalancerClient loadBalancerClient;

	@Autowired
	public ClientConfiguration(LoadBalancerClient client) {
		this.loadBalancerClient = client;
	}

	@Bean(name = "clientDetails")
	ClientDetailsService clientDetailsService(ClientRepository clientRepository) {
		return clientId -> clientRepository.findByClientId(clientId).map(client -> {

			BaseClientDetails details = new BaseClientDetails(client.getClientId(), null, client.getScopes(),
					client.getAuthorizedGrantTypes(), client.getAuthorities());
			details.setClientSecret("{noop}" + client.getSecret());

			// <1>
			// details.setAutoApproveScopes
			// (Arrays.asList(client.getAutoApproveScopes().split(",")));

			// <2>
			String greetingsClientRedirectUri = Optional.ofNullable(this.loadBalancerClient.choose("api-service"))
					.map(si -> "http://" + si.getHost() + ':' + si.getPort() + '/').orElseGet(() -> "");

			Set<String> redirects = new HashSet<>();
			redirects.add("http://localhost:8082/ui/login");
			redirects.add("http://localhost:8083/ui2/login");
			
			details.setRegisteredRedirectUri(redirects);
			return details;
		}).orElseThrow(() -> new ClientRegistrationException(String.format("no client %s registered", clientId)));
	}
}
