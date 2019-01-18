package net.devk.marketing.service.contacts;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.devk.marketing.service.contacts.dto.ContactTypeRequestDTO;
import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.model.ContactInfo;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.RegistrationStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTests {

	@Autowired
	private ContactService contactService;

	@Autowired
	private CustomerService customerService;

	@Test
	public void testSaveContactInfo() {

		Customer customer = customerService.createCustomer("koorosh01", true, "123", "nine", 12, 2232, false,
				RegistrationStatus.FINISHED, "koorosh01", 1L, 1L, 1L, 1L);

		List<ContactTypeRequestDTO> contactTypes = new ArrayList<>();
		contactTypes.add(new ContactTypeRequestDTO(1L, "09123853840"));

		ContactInfo contactInfo = contactService.createContactInfo(customer.getId(), 1L, "ali", contactTypes);

		Assert.assertNotNull(contactInfo);

	}

}
