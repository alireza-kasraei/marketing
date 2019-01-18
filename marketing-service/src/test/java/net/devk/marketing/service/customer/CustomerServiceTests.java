package net.devk.marketing.service.customer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.CustomerAddress;
import net.devk.marketing.service.model.RegistrationStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTests {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testSaveCustomer() {

		Customer customer = customerService.createCustomer("koorosh01", true, "123", "456", 1, 123, true,
				RegistrationStatus.EARLY, "koorosh01", 1L, 2L, 1L, 1L);
		Assert.assertNotNull(customer);
	}

	@Test
	public void testSaveCustomerAddress() {

		Customer customer = customerService.createCustomer("koorosh01", true, "123", "456", 1, 123, true,
				RegistrationStatus.EARLY, "koorosh01", 1L, 2L, 1L, 1L);
		CustomerAddress addAddress = customerService.addAddress(customer.getId(), "9263492374928", "asdaldhalk",
				"aksdjgajkhda");
		Assert.assertNotNull(addAddress);
	}

}
