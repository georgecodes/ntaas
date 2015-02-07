package com.elevenware.ntaas;

import com.elevenware.ntaas.resources.AlliterationResource;
import com.elevenware.ntaas.resources.FrontPage;
import com.elevenware.ntaas.resources.NameResource;
import com.elevenware.ntaas.resources.StatusResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

public class NtaasConfig extends ResourceConfig {

    public NtaasConfig() {
        register(NameResource.class);
        register(AlliterationResource.class);
        register(FrontPage.class);
        register(StatusResource.class);
        property(FreemarkerMvcFeature.TEMPLATES_BASE_PATH, "/freemarker");
        register(FreemarkerMvcFeature.class);
    }
}