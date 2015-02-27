package com.elevenware.ntaas;

import com.elevenware.ntaas.controllers.FrontPageController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ViewTests {

    private MockMvc mockMvc;
    
    @Test
    public void frontPageExists() throws Exception {
        
        mockMvc.perform(get("/")
        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("index.html"));

    }

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new FrontPageController()).build();
    }


}
