package net.devk.authorization.client;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import net.devk.authorization.client.dto.ScopeDTO;
import net.devk.authorization.model.Authority;
import net.devk.authorization.model.Client;
import net.devk.authorization.model.GrantType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;

	@Test
	public void testFindByValidName() {
		Optional<Client> optional = clientRepository.findByName("client1");
		Assert.assertTrue(optional.isPresent());
	}

	@Test
	public void testFindByInvalidName() {
		Optional<Client> optional = clientRepository.findByName("client");
		Assert.assertFalse(optional.isPresent());
	}

	@Test
	public void testFindScopes() {
		List<ScopeDTO> scopes = clientRepository.findScopes("client1");
		Assert.assertFalse(scopes.isEmpty());
	}

	@Transactional
	@Test
	public void testGetAuthorities() {
		Optional<Client> optional = clientRepository.findByName("client1");
		Client client = optional.get();
		Set<Authority> authorities = client.getAuthorities();
		Assert.assertFalse(authorities.isEmpty());
	}

	@Test
	public void testFindAuthorities() {
		List<String> authorities = clientRepository.findAuthorities("client1");
		Assert.assertFalse(authorities.isEmpty());
	}

	@Test
	public void testFindRedirects() {
		List<String> redirects = clientRepository.findRedirects("client1");
		Assert.assertFalse(redirects.isEmpty());
	}

	@Test
	public void testFindGrantTypes() {
		List<GrantType> grantTypes = clientRepository.findGrantTypes("client1");
		Assert.assertFalse(grantTypes.isEmpty());
	}

	@Test
	public void testInvalidFindAuthorities() {
		List<String> authorities = clientRepository.findAuthorities("client12");
		Assert.assertTrue(authorities.isEmpty());
	}

	@Test
	public void testInvalidFindRedirects() {
		List<String> redirects = clientRepository.findRedirects("client12");
		Assert.assertTrue(redirects.isEmpty());
	}

	@Test
	public void testInvalidFindGrantTypes() {
		List<GrantType> grantTypes = clientRepository.findGrantTypes("client12");
		Assert.assertTrue(grantTypes.isEmpty());
	}

}
