package com.elevenware.ntaas;

import com.elevenware.ntaas2.NtaasConfig;
import com.elevenware.ntaas2.model.Name;
import com.elevenware.nyaaas.RandomNumber;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;

public class NameTests extends JerseyTest {

    @Test
    public void plainTextNameResource() {

        String name = target("/name").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("mute-trial", name);

    }

    @Test
    public void jsonTextNameResource() {

        Name name = target("/name").request().accept(MediaType.APPLICATION_JSON).get(Name.class);
        assertEquals("mute-trial", name.getName());

    }

    @Test
    public void xmlTextNameResource() {

        Name name = target("/name").request().accept(MediaType.APPLICATION_XML).get(Name.class);
        assertEquals("mute-trial", name.getName());

    }

    @Test
    public void plainTextNameResourceWithNumber() {

        String name = target("/name/number").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("mute-trial-8173", name);

    }

    @Test
    public void jsonTextNameResourceWithNumber() {

        Name name = target("/name/number").request().accept(MediaType.APPLICATION_JSON).get(Name.class);
        assertEquals("mute-trial-8173", name.getName());

    }

    @Test
    public void xmlTextNameResourceWithNumber() {

        Name name = target("/name/number").request().accept(MediaType.APPLICATION_XML).get(Name.class);
        assertEquals("mute-trial-8173", name.getName());

    }

    @Before
    public void setup() {
        RandomNumber.seed(23847L);
    }

    @Override
    protected Application configure() {
        return new NtaasConfig();
    }

}
