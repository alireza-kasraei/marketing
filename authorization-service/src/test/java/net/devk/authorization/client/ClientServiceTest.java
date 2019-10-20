package net.devk.authorization.client;

import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import net.devk.authorization.client.dto.ScopeDTO;
import net.devk.authorization.model.GrantType;

@RunWith(SpringRunner.class)
public class ClientServiceTest {

	@MockBean
	private ClientRepository clientRepository;

	private ClientService clientService;

	@Before
	public void init() {
		clientService = new ClientServiceImpl(clientRepository);
	}

	@Test
	public void testCreateClientScopeNames() {
		given(clientRepository.findScopes(Mockito.anyString()))
				.willReturn(Arrays.asList(new ScopeDTO("SCOPE1", true), new ScopeDTO("SCOPE2", false)));
		String scopes = clientService.createClientScopeNames("SAMPLE");
		Assert.assertEquals("SCOPE1,SCOPE2", scopes);
	}

	@Test
	public void testFindClientAutoApprovedScopeNames() {
		given(clientRepository.findScopes(Mockito.anyString()))
				.willReturn(Arrays.asList(new ScopeDTO("SCOPE1", true), new ScopeDTO("SCOPE2", false)));
		List<String> scopes = clientService.findClientAutoApprovedScopeNames("SAMPLE");
		Assert.assertEquals(1, scopes.size());
		Assert.assertEquals("SCOPE1", scopes.get(0));
	}

	@Test
	public void testCreateClientAuthorities() {
		given(clientRepository.findAuthorities(Mockito.anyString())).willReturn(Arrays.asList("ROLE1", "ROLE2"));
		String authorities = clientService.createClientAuthorities("SAMPLE");
		Assert.assertEquals("ROLE1,ROLE2", authorities);
	}

	@Test
	public void testCreateClientRedirects() {
		given(clientRepository.findRedirects(Mockito.anyString())).willReturn(Arrays.asList("http://r1", "http://r2"));
		String redirects = clientService.createClientRedirects("SAMPLE");
		Assert.assertEquals("http://r1,http://r2", redirects);
	}

	@Test
	public void testCreateClientGrantTypes() {
		given(clientRepository.findGrantTypes(Mockito.anyString()))
				.willReturn(Arrays.asList(GrantType.AUTHORIZATION_CODE, GrantType.PASSWORD));
		String grantTypes = clientService.createClientGrantTypes("SAMPLE");
		Assert.assertEquals("authorization_code,password", grantTypes);
	}

}
