package com.elevenware.ntaas;

import freemarker.ext.servlet.FreemarkerServlet;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import javax.ws.rs.core.Application;

public abstract class AbstractNtaasApplicationTests extends JerseyTest {
    @Override
    protected Application configure() {
        enable(TestProperties.DUMP_ENTITY);
        enable(TestProperties.LOG_TRAFFIC);
        enable(FreemarkerMvcFeature.class.getCanonicalName());
        return new NtaasConfig();
    }
}
