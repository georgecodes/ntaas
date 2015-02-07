package com.elevenware.ntaas2;

import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

public class ClasspathResourceHandler extends ResourceHandler {
    @Override
    public Resource getResource(String resourceString) {

        if(resourceString == null || resourceString.equals("/") || resourceString.equals("")) {
            resourceString = "/index.html";
        }
        resourceString = "/public".concat(resourceString);
        return Resource.newClassPathResource(resourceString);
    }



}
