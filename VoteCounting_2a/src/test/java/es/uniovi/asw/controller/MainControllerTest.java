package es.uniovi.asw.controller;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.Application;
import es.uniovi.asw.service.RecuentoService;
import es.uniovi.asw.service.VotoService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })

public class MainControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	
	@Autowired
	private VotoService votoService;

	@Autowired
	private RecuentoService recuentoService;

	
	@Before
	public void setUp() throws Exception {
		
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	

	@Test
	public void testLanding() throws Exception {
		
		mvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Voting")));
		
	}
	
	@Test
	 public void testrealizarRecuentoError() throws Exception{	
		
	        MainController controller = new MainController();
	        ModelAndView modelAndView = controller.realizarRecuento(null);	
	        
	        assertEquals("error", modelAndView.getViewName());
	        assertNotNull(modelAndView.getModel());
	 }
	
	
	@Test
	 public void testresultadosOnlineError() throws Exception{
		
	        MainController controller = new MainController();
	        ModelAndView modelAndView = controller.verResultadosOnline(null);
	        
	        assertEquals("error", modelAndView.getViewName());
	        assertNotNull(modelAndView.getModel());
	 }
	
	@Test
	 public void testEstadisticasError() throws Exception{
		
	        MainController controller = new MainController();
	        ModelAndView modelAndView = controller.verEstadisticas(null);
	        
	        assertEquals("error", modelAndView.getViewName());
	        assertNotNull(modelAndView.getModel());
	 }
	
	
}
