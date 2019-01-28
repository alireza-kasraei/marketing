package net.devk.marketing.service.customer;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import net.devk.marketing.service.customers.CustomerService;
import net.devk.marketing.service.customers.dto.CustomerFindAllQueryResultDTO;
import net.devk.marketing.service.model.Customer;
import net.devk.marketing.service.model.RegistrationStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTests {

	@Autowired
	private CustomerService customerService;

	@Test
	@Transactional
	public void testSaveCustomer() {
		// data.sql
		Customer customer = customerService.createCustomer("DUMMY CUSTOMER", 1L, true, "ye sectione khoob", "123231231",
				"43453453453", "dfggdfgd", "admin");
		Assert.assertNotNull(customer.getId());
		Assert.assertEquals(RegistrationStatus.EARLY, customer.getRegistrationStatus());
		customerService.updateCustomer(customer.getId(), "ye code khoob", 12, 1L, 1L, 123454321L);
		Assert.assertEquals(RegistrationStatus.FINISHED, customer.getRegistrationStatus());
	}

	@Test
	public void testFindCustomers() {
		// data.sql , there are three customers with koorosh01 name
		List<CustomerFindAllQueryResultDTO> customers = customerService.findAllCustomersLikeByName("koorosh");
		assertEquals(3, customers.size());
	}

}
