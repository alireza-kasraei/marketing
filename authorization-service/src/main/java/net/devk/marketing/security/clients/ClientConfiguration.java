package net.devk.marketing.security.clients;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import net.devk.marketing.security.clients.dto.ScopeDTO;
import net.devk.marketing.security.model.Authority;
import net.devk.marketing.security.model.ClientGrantType;
import net.devk.marketing.security.model.GrantType;
import net.devk.marketing.security.model.Redirect;

@Configuration
public class ClientConfiguration {

	@Bean(name = "clientDetails")
	ClientDetailsService clientDetailsService(ClientRepository clientRepository) {
		return name -> clientRepository.findByName(name).map(client -> {

			List<ScopeDTO> scopes = clientRepository.findScopes(name);

			final String scopeNames = scopes.stream().map(ScopeDTO::getScopeName).collect(Collectors.joining(","));

			List<String> autoApprovedScopeNames = scopes.stream()
					.filter(sc -> sc.getAutoApproved() != null && sc.getAutoApproved().booleanValue())
					.map(ScopeDTO::getScopeName).collect(Collectors.toList());

			final String authorities = client.getAuthorities().stream().map(Authority::getName)
					.collect(Collectors.joining(","));
			final String redirects = client.getRedirects().stream().map(Redirect::getUrl)
					.collect(Collectors.joining(","));
			final String grantTypes = client.getGrantTypes().stream().map(ClientGrantType::getGrantType)
					.map(GrantType::name).map(String::toLowerCase).collect(Collectors.joining(","));

			BaseClientDetails details = new BaseClientDetails(client.getName(), null, scopeNames, grantTypes,
					authorities, redirects);

			details.setClientSecret(client.getSecret());

			details.setAutoApproveScopes(autoApprovedScopeNames);

//			String greetingsClientRedirectUri = Optional.ofNullable(this.loadBalancerClient.choose("api-service"))
//					.map(si -> "http://" + si.getHost() + ':' + si.getPort() + '/').orElseGet(() -> "");

			return details;
		}).orElseThrow(() -> new ClientRegistrationException(String.format("no client %s registered", name)));
	}

}
