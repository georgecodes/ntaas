package com.elevenware.ntaas;

import com.elevenware.ntaas.controllers.AlliterationController;
import com.elevenware.nyaaas.RandomNumber;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@WebAppConfiguration
public class AlliterationTests {
    
    private MockMvc mockMvc;

    @Test
    public void plainTextAlliteration() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                get("/alliteration/f")
                        .accept(MediaType.TEXT_PLAIN)
        ).andExpect(status().isOk())
                .andReturn();

        String name = mvcResult.getResponse().getContentAsString();

        assertEquals("fallacious-freckle", name);

    }

    @Test
    public void jsonAlliteration() throws Exception {

        mockMvc.perform(
                get("/alliteration/f")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("fallacious-freckle")));


    }

    @Test
    public void xmlAlliteration() throws Exception {

        mockMvc.perform(
                get("/alliteration/f")
                        .accept(MediaType.APPLICATION_XML)
        ).andExpect(status().isOk())
                .andExpect(xpath("//name/@name").string("fallacious-freckle"));

    }

    @Before
    public void setup() {
        RandomNumber.seed(73654L);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AlliterationController()).build();
    }

}
