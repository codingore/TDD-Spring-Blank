package blank.views;

import static org.junit.Assert.*;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@RunWith(org.jboss.arquillian.junit.Arquillian.class)
public class LoginTest {

	@Drone
    private WebDriver browser;
	
	private URL deploymentUrl;
	
	@Before
	public void setUp() throws Exception {
		deploymentUrl = new URL("http://127.0.0.1:8080/blank");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFrontPage() {
		browser.get(deploymentUrl.toExternalForm() + "/login.yo");
		WebElement emailWE = browser.findElement(By.id("emailE"));
		assertNotNull(emailWE);
		WebElement passwordWE = browser.findElement(By.id("passwordE"));
		assertNotNull(passwordWE);
		WebElement messageWE = browser.findElement(By.id("messageE"));
		assertNotNull(messageWE);
		WebElement loginWE = browser.findElement(By.id("loginE"));
		assertNotNull(loginWE);
	}

	@Test
	public void testLoginEmailNotFound() {
		browser.get(deploymentUrl.toExternalForm() + "/login.yo");
		WebElement emailWE = browser.findElement(By.id("emailE"));
		assertNotNull(emailWE);
		WebElement passwordWE = browser.findElement(By.id("passwordE"));
		assertNotNull(passwordWE);
		WebElement messageWE = browser.findElement(By.id("messageE"));
		assertNotNull(messageWE);
		WebElement loginWE = browser.findElement(By.id("loginE"));
		assertNotNull(loginWE);
		emailWE.sendKeys("codingore@paybat.com");
		guardHttp(loginWE).click();		
		assertEquals("Email is not found!", messageWE.getText());
	}

	@Test
	public void testLoginPasswordNotMatch() {
		browser.get(deploymentUrl.toExternalForm() + "/login.yo");
		WebElement emailWE = browser.findElement(By.id("emailE"));
		assertNotNull(emailWE);
		WebElement passwordWE = browser.findElement(By.id("passwordE"));
		assertNotNull(passwordWE);
		WebElement messageWE = browser.findElement(By.id("messageE"));
		assertNotNull(messageWE);
		WebElement loginWE = browser.findElement(By.id("loginE"));
		assertNotNull(loginWE);
		emailWE.sendKeys("codingore@gmail.com");
		guardHttp(loginWE).click();		
		assertEquals("Password does not match!", messageWE.getText());
	}

	@Test
	public void testLoginSuccess() {
		browser.get(deploymentUrl.toExternalForm() + "/login.yo");
		WebElement emailWE = browser.findElement(By.id("emailE"));
		assertNotNull(emailWE);
		WebElement passwordWE = browser.findElement(By.id("passwordE"));
		assertNotNull(passwordWE);
		WebElement messageWE = browser.findElement(By.id("messageE"));
		assertNotNull(messageWE);
		WebElement loginWE = browser.findElement(By.id("loginE"));
		assertNotNull(loginWE);
		emailWE.sendKeys("codingore@gmail.com");
		passwordWE.sendKeys("homosapien");
		guardHttp(loginWE).click();		
		assertEquals(true, browser.getCurrentUrl().endsWith("/index.yo"));
	}
	
}
