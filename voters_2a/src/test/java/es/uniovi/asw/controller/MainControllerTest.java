package es.uniovi.asw.controller;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import es.uniovi.asw.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class MainControllerTest {

	@Value("${local.server.port}")
	private int port;
	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		//this.base = new URL("http://localhost:" + port + "/");
		//template = new TestRestTemplate();
	}

	@Test
	public void getLanding() throws Exception {
		// String userURI = base.toString() + "/user";
		// ResponseEntity<String> response =
		// template.getForEntity(base.toString(), String.class);
		// assertThat(response.getBody(), equalTo("User Management Service"));
	}

	@Test
	public void getUser() throws Exception {
		// String userURI = base.toString() + "/user";
		// ResponseEntity<String> response = template.getForEntity(userURI,
		// String.class);
		// UserInfo expected = new UserInfo("pepe",0);
	}
	
	@Test(expected=ResourceNotFoundException.class)
	public void validarTesteo() throws Exception{
		MainController m = new MainController();
		m.validar(null);
		
	}

}