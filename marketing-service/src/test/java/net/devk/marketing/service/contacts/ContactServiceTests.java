package net.devk.marketing.service.contacts;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.devk.marketing.service.contacts.dto.ContactInfoQueryResultDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTests {

	@Autowired
	private ContactService contactService;

	@Test
	public void testFindContactInfo() {
		// data.sql
		List<ContactInfoQueryResultDTO> contactsInfo = contactService.findAllContactsInfo(1109L);
		assertNotEquals(0, contactsInfo);
	}

}
