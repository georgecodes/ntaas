package com.elevenware.ntaas2.resources;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class FrontPage {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable frontPage() {
        return new Viewable("/index.ftl");
    }

}
