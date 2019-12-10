/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xdlr.civilization.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserActionControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void registerRequest() throws Exception {
		this.mockMvc.perform(get("/register").param("userId", "001"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.userId").value(001))
				.andExpect(jsonPath("$.userAction").value(UserActionResponse.ACTION_TYPE_REGISTER));
	}

	@Test
	public void throwRubbish() throws Exception {
		this.mockMvc.perform(get("/rubbish").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.userAction").value(UserActionResponse.ACTION_TYPE_GARBAGE));
	}

	@Test
	public void vending() throws Exception {
		this.mockMvc.perform(get("/vending").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.userAction").value(UserActionResponse.ACTION_TYPE_VENDING_MACHINE));
	}
}
