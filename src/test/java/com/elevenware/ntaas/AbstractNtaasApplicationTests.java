package com.elevenware.ntaas;

import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

public abstract class AbstractNtaasApplicationTests extends JerseyTest {
    @Override
    protected Application configure() {
        return new NtaasConfig();
    }
}
