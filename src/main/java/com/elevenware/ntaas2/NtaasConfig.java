package com.elevenware.ntaas2;

import com.elevenware.ntaas2.resources.AlliterationResource;
import com.elevenware.ntaas2.resources.FrontPage;
import com.elevenware.ntaas2.resources.NameResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

public class NtaasConfig extends ResourceConfig {

    public NtaasConfig() {
        register(NameResource.class);
        register(AlliterationResource.class);
        register(FrontPage.class);
        register(FreemarkerMvcFeature.class);
    }
}