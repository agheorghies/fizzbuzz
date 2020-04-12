package com.github.agheorghies.fizzbuzz.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzbuzzControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetFizzbuzzForRange_withValidParameters() throws Exception {
        String url = "/fizzbuzz/0/6";

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[\"fizzbuzz\",\"1\",\"2\",\"three\",\"4\",\"buzz\",\"fizz\"]")));
    }

    @Test
    public void testGetFizzbuzzForRange_withInvalidParameters() throws Exception {
        String url = "/fizzbuzz/0/abc";

        mockMvc.perform(get(url))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("{\"error\":\"For input string: \\\"abc\\\" - expected integer value\"}")));
    }
}
