package com.elevenware.ntaas.resources;

import com.elevenware.ntaas.model.Name;
import com.elevenware.ntaas.model.Status;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/status")
public class StatusResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Status xmlStatus() {
        return new Status();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Status jsonStatus() {
        return new Status();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String nameAsText(@PathParam("letter") String letter) {
        return new Status().toString();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable statusPage() {
        Map model = new HashMap<>();
        model.put("status", new Status());
        return new Viewable("/status.ftl", model);
    }

}
