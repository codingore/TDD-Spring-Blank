package blank.models;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.internal.EntityManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/test-yo-servlet.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class UserTest {

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() throws Exception {
		executeSQLFile("blank/models/Schema.sql");
		executeSQLFile("blank/models/UserSample.sql");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	protected void executeSQLFile(String filename) throws Exception {
		SchemaService ss = (SchemaService)wac.getBean("schemaService");
		ss.executeSqlScript(filename);
	}
	
	@Test
	public void test001_AddUser() throws Exception {
		UserService us = (UserService)wac.getBean("userService");

		User nu = new User();
		nu.setCode("57567a8653346");
		nu.setEmail("john@blank.com");
		nu.setName("John Smith");
		nu.setPassword("4A461B6EF3A930876BD71CEB030126F5");
		us.addUser(nu);
		
		List<User> ul = us.listUsers();
		
		assertEquals(2, ul.size());

		Map<String, User> um = new HashMap<String, User>();
		for (int i = 0; i < ul.size(); i++) {
			um.put(ul.get(i).getEmail(), ul.get(i));
		}
		
		assertEquals(true, um.containsKey("john@blank.com"));
		User u = um.get("john@blank.com");
		assertEquals("4A461B6EF3A930876BD71CEB030126F5", u.getPassword());
		assertEquals("John Smith", u.getName());
		
	}
	
	@Test
	public void test002_UpdateUser() throws Exception {
		UserService us = (UserService)wac.getBean("userService");
		
		List<User> ul = us.listUsers();

		assertEquals(1, ul.size());

		Map<String, User> um = new HashMap<String, User>();
		for (int i = 0; i < ul.size(); i++) {
			um.put(ul.get(i).getEmail(), ul.get(i));
		}
		
		assertEquals(true, um.containsKey("codingore@gmail.com"));
		User u = um.get("codingore@gmail.com");

		u.setEmail("john@blank.com");
		u.setName("John Smith");
		u.setPassword("4A461B6EF3A930876BD71CEB030126F5");
		
		us.updateUser(u);

		ul = us.listUsers();

		assertEquals(1, ul.size());

		um = new HashMap<String, User>();
		for (int i = 0; i < ul.size(); i++) {
			um.put(ul.get(i).getEmail(), ul.get(i));
		}
		
		assertEquals(true, um.containsKey("john@blank.com"));
		u = um.get("john@blank.com");
		
		assertEquals("4A461B6EF3A930876BD71CEB030126F5", u.getPassword());
		assertEquals("John Smith", u.getName());
		
	}
	
	@Test
	public void test003_RemoveUser() throws Exception {
		UserService us = (UserService)wac.getBean("userService");
		List<User> ul = us.listUsers();
		
		assertEquals(1, ul.size());

		Map<String, User> um = new HashMap<String, User>();
		for (int i = 0; i < ul.size(); i++) {
			um.put(ul.get(i).getEmail(), ul.get(i));
		}
		
		assertEquals(true, um.containsKey("codingore@gmail.com"));
		User u = um.get("codingore@gmail.com");

		us.removeUser(u.getCode());

		ul = us.listUsers();
		
		assertEquals(0, ul.size());
	}
	
	@Test
	public void test004_ListUser() throws Exception {
		UserService us = (UserService)wac.getBean("userService");
		
		System.out.println("P1");
		
		List<User> ul = us.listUsers();

		System.out.println("P2");
		
		assertEquals(1, ul.size());

		Map<String, User> um = new HashMap<String, User>();
		for (int i = 0; i < ul.size(); i++) {
			um.put(ul.get(i).getEmail(), ul.get(i));
		}
		
		assertEquals(true, um.containsKey("codingore@gmail.com"));
		User u = um.get("codingore@gmail.com");
		assertEquals("4A461B6EF3A930876BD71CEB030126F5", u.getPassword());
		assertEquals("Tran Dinh Thoai", u.getName());
	}

	@Test
	public void test005_GetUserByEmail() throws Exception {
		UserService us = (UserService)wac.getBean("userService");

		User u = us.getUserByEmail("codingore@gmail.com");
		
		assertNotNull(u);
		assertEquals("4A461B6EF3A930876BD71CEB030126F5", u.getPassword());
		assertEquals("Tran Dinh Thoai", u.getName());
	}

	@Test
	public void test006_GetUserByCode() throws Exception {
		UserService us = (UserService)wac.getBean("userService");

		User nu = us.getUserByEmail("codingore@gmail.com");
		User u = us.getUserByCode(nu.getCode());
		
		assertNotNull(u);
		assertEquals("4A461B6EF3A930876BD71CEB030126F5", u.getPassword());
		assertEquals("Tran Dinh Thoai", u.getName());
	}
	
}
