package com.elevenware.ntaas;

import com.elevenware.ntaas.controllers.NameController;
import com.elevenware.nyaaas.RandomNumber;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

public class NameTests  {

    private MockMvc mockMvc;

    @Test
    public void plainTextNameResource() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                get("/name")
                        .accept(MediaType.TEXT_PLAIN)
        ).andExpect(status().isOk())
                .andReturn();

        String name = mvcResult.getResponse().getContentAsString();

        assertEquals("mute-trial", name);

    }

    @Test
    public void jsonTextNameResource() throws Exception {

        mockMvc.perform(
                get("/name")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("mute-trial")));

    }

    @Test
    public void xmlTextNameResource() throws Exception {

        mockMvc.perform(
                get("/name")
                        .accept(MediaType.APPLICATION_XML)
        ).andExpect(status().isOk())
                .andExpect(xpath("//name/@name").string("mute-trial"));

    }

    @Test
    public void plainTextNameResourceWithNumber() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                get("/name/number")
                        .accept(MediaType.TEXT_PLAIN)
        ).andExpect(status().isOk())
                .andReturn();

        String name = mvcResult.getResponse().getContentAsString();

        assertEquals("mute-trial-8173", name);

    }

    @Test
    public void jsonTextNameResourceWithNumber() throws Exception {

        mockMvc.perform(
                get("/name/number")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("mute-trial-8173")));

    }

    @Test
    public void xmlTextNameResourceWithNumber() throws Exception {

        mockMvc.perform(
                get("/name/number")
                        .accept(MediaType.APPLICATION_XML)
        ).andExpect(status().isOk())
                .andExpect(xpath("//name/@name").string("mute-trial-8173"));

    }

    @Before
    public void setup() {
        RandomNumber.seed(23847L);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new NameController()).build();
    }

}
