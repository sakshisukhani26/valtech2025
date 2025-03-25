package com.valtech.training.registerservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testGetUserByValidId() throws Exception{
		mockMvc.perform(get("/api/v1/users/4")).andDo(print())
		.andExpect(content().json("{\n"
				+ "    \"id\": 4,\n"
				+ "    \"name\": \"abc\",\n"
				+ "    \"age\": 22,\n"
				+ "    \"mobile\": \"987654321\",\n"
				+ "    \"email\": \"xyz@gmail.com\",\n"
				+ "    \"kid\": false,\n"
				+ "    \"subscriptionId\": 1\n"
				+ "}"))
		.andExpectAll(status().isOk());
	}
	
	@Test
	void testGetUserByInvalidId() throws Exception{
		mockMvc.perform(get("/api/v1/users/0")).andDo(print())
		.andExpectAll(status().isNotFound());
	}
}
