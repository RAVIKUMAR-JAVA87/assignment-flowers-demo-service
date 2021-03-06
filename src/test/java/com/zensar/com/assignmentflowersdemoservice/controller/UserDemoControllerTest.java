package com.zensar.com.assignmentflowersdemoservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class UserDemoControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	void testGetUsers() throws Exception {
		String restUrl = "/flowers/api/users";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(restUrl).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.length() > 0);
	}

	@Test
	public void testGetUniqueUsers() throws Exception {
		String restUrl = "/flowers/api/uniqueUsers";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(restUrl).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.length() > 0);
	}

	@Test
	void testUpdateUser() throws Exception {
		String restUrl = "/flowers/api/user/4?value=1800Flowers";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(restUrl).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.length() > 0);
	}

}
