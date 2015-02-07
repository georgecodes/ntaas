package com.elevenware.ntaas;

import com.elevenware.ntaas.model.Name;
import com.elevenware.nyaaas.RandomNumber;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;

public class AlliterationTests extends JerseyTest {

    @Test
    public void plainTextAlliteration() {

        String name = target("/alliteration/f").request().accept(MediaType.TEXT_PLAIN).get(String.class);

        assertEquals("fallacious-freckle", name);

    }

    @Test
    public void jsonAlliteration() {

        Name name = target("/alliteration/f").request().accept(MediaType.APPLICATION_JSON).get(Name.class);

        assertEquals("fallacious-freckle", name.getName());

    }

    @Test
    public void xmlAlliteration() {

        Name name = target("/alliteration/f").request().accept(MediaType.APPLICATION_XML).get(Name.class);

        assertEquals("fallacious-freckle", name.getName());

    }

    @Before
    public void setup() {
        RandomNumber.seed(73654L);
    }

    @Override
    protected Application configure() {
        return new NtaasConfig();
    }
}
