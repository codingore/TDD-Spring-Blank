package blank.controllers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.UUID;

import javax.swing.text.AbstractDocument.Content;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import blank.Crypto;
import blank.models.SchemaService;
import blank.models.User;
import blank.models.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/test-yo-servlet.xml")
public class LoginTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	protected void executeSQLFile(String filename) throws Exception {
		SchemaService ss = (SchemaService)wac.getBean("schemaService");
		ss.executeSqlScript(filename);
	}
	
	@Before
	public void setUp() throws Exception {
		executeSQLFile("blank/models/Schema.sql");
		executeSQLFile("blank/models/UserSample.sql");
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFrontPage() throws Exception {
		this.mockMvc.perform(get("/login")
				.accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk()
						);
	}

	@Test
	public void testLoginEmailNotFound() throws Exception {
		User u = new User();
		u.setEmail("codingore@paybat.com");
		u.setPassword("");
		this.mockMvc.perform(
				post("/login")
				.param("email", u.getEmail())
				.param("password", u.getPassword())
				.requestAttr("user", u)
				.accept(MediaType.TEXT_HTML)
				)
				.andExpect(status().isOk())
				.andExpect(model().attribute("message", "Email is not found!"));
	}

	@Test
	public void testLoginPasswordNotMatch() throws Exception {
		User u = new User();
		u.setEmail("codingore@gmail.com");
		u.setPassword("");
		this.mockMvc.perform(
				post("/login")
				.param("email", u.getEmail())
				.param("password", u.getPassword())
				.requestAttr("user", u)
				.accept(MediaType.TEXT_HTML)
				)
				.andExpect(status().isOk())
				.andExpect(model().attribute("message", "Password does not match!"));
	}

	@Test
	public void testLoginSuccess() throws Exception {
		User u = new User();
		u.setEmail("codingore@gmail.com");
		u.setPassword("homosapien");
		this.mockMvc.perform(
				post("/login")
				.param("email", u.getEmail())
				.param("password", u.getPassword())
				.requestAttr("user", u)
				.accept(MediaType.TEXT_HTML)
				)
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/index.yo"));
	}
	
}
