package net.devk.authorization;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SecuredPrincipleRestControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@Test
	public void withoutCredentials() throws Exception {
		mvc.perform(get("/secured/user")).andExpect(status().isUnauthorized());
	}

	@WithMockUser(roles = "USER")
	@Test
	public void withCredentials() throws Exception {
		mvc.perform(get("/secured/user")).andExpect(status().isOk());
	}

	@WithMockUser(roles = "TEST")
	@Test
	public void withInvalidCredentials() throws Exception {
		mvc.perform(get("/secured/user")).andExpect(status().isUnauthorized());
	}
}