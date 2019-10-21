package net.devk.authorization.client;

import java.util.List;
import java.util.Optional;

import net.devk.authorization.model.Client;

public interface ClientService {

	public Optional<Client> findByName(String name);

	public String createClientScopeNames(String name);

	public List<String> findClientAutoApprovedScopeNames(String name);

	public String createClientAuthorities(String name);

	public String createClientRedirects(String name);

	public String createClientGrantTypes(String name);

}
