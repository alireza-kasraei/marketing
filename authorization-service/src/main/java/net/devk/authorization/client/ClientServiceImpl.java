package net.devk.authorization.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.devk.authorization.client.dto.ScopeDTO;
import net.devk.authorization.model.Client;
import net.devk.authorization.model.GrantType;

@Service
class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public Optional<Client> findByName(String name) {
		return clientRepository.findByName(name);
	}

	@Override
	public String createClientScopeNames(String name) {
		return clientRepository.findScopes(name).stream().map(ScopeDTO::getScopeName).collect(Collectors.joining(","));
	}

	@Override
	public List<String> findClientAutoApprovedScopeNames(String name) {
		return clientRepository.findScopes(name).stream()
				.filter(sc -> sc.getAutoApproved() != null && sc.getAutoApproved().booleanValue())
				.map(ScopeDTO::getScopeName).collect(Collectors.toList());
	}

	@Override
	public String createClientAuthorities(String name) {
		return clientRepository.findAuthorities(name).stream().collect(Collectors.joining(","));
	}

	@Override
	public String createClientRedirects(String name) {
		return clientRepository.findRedirects(name).stream().collect(Collectors.joining(","));
	}

	@Override
	public String createClientGrantTypes(String name) {
		return clientRepository.findGrantTypes(name).stream().map(GrantType::name).map(String::toLowerCase)
				.collect(Collectors.joining(","));
	}

}
