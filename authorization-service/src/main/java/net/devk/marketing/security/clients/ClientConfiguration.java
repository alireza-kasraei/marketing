package net.devk.marketing.security.clients;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.util.StringUtils;

@Configuration
public class ClientConfiguration {

	@Bean(name = "clientDetails")
	ClientDetailsService clientDetailsService(ClientRepository clientRepository) {
		return clientId -> clientRepository.findByClientId(clientId).map(client -> {

			BaseClientDetails details = new BaseClientDetails(client.getClientId(), null, client.getScopes(),
					client.getAuthorizedGrantTypes(), client.getAuthorities());
			details.setClientSecret("{noop}" + client.getSecret());

			// details.setAutoApproveScopes
			// (Arrays.asList(client.getAutoApproveScopes().split(",")));

//			String greetingsClientRedirectUri = Optional.ofNullable(this.loadBalancerClient.choose("api-service"))
//					.map(si -> "http://" + si.getHost() + ':' + si.getPort() + '/').orElseGet(() -> "");

			final String redirectUrls = client.getRedirectUrls();
			Stream<String> stream = Arrays.stream(StringUtils.commaDelimitedListToStringArray(redirectUrls));
			Set<String> urls = stream.collect(Collectors.toSet());
			details.setRegisteredRedirectUri(urls);
			return details;
		}).orElseThrow(() -> new ClientRegistrationException(String.format("no client %s registered", clientId)));
	}
}
