package net.devk.authorization.client;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.devk.authorization.model.Client;

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

}
