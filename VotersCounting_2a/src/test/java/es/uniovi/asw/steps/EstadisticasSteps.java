package es.uniovi.asw.steps;

public class EstadisticasSteps {

//	@Autowired
//	protected WebApplicationContext context;
//
//	protected MockMvc mvc;
//	protected MvcResult result;
//
//	private String url = "/estadisticas?idEleccion=1";
//
//	@Value("${local.server.port}")
//	protected int port;
//
//	@When("^the client calls /$")
//	public void the_client_calls() throws Throwable {
//		if (this.url == null) {
//			this.url = "/";
//		}
//		Assert.notNull(context);
//		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
//		result = mvc.perform(get(url)).andReturn();
//	}
//
//	@Then("^the client receives status code of (\\d+)$")
//	public void the_client_receives_status_code_of(int status) throws Throwable {
//		assertThat(result.getResponse().getStatus(), is(status));
//	}
//
//	@Then("^the client receives the string \"([^\"]*)\"$")
//	public void the_client_receives_the_string(String str) throws Throwable {
//		assertThat(result.getResponse().getContentAsString(), containsString(str));
//	}
}
