package com.tianbao54.aop;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.tianbao54.aop.config.SpringConfiguration;
import com.tianbao54.aop.controller.AOPController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfiguration.class })
@WebAppConfiguration
@TestPropertySource("classpath:config.properties")
public class AppTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private MockHttpServletRequest request;
	@Autowired
	private MockHttpServletResponse response;
	@Autowired
	private AOPController aopController;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
    private Environment environment;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void testLogin() throws Exception {
		
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/aop/login").param("username", environment.getRequiredProperty("username")).param("password", environment.getRequiredProperty("password")))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}
}
