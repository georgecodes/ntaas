package com.elevenware.ntaas2.resources;

import com.elevenware.ntaas2.model.Name;
import com.elevenware.nyaaas.NameService;
import com.elevenware.nyaaas.SimpleNameService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/alliteration")
public class AlliterationResource {

    private NameService nameService = new SimpleNameService();

    @GET
    @Path("/{letter}")
    @Produces(MediaType.APPLICATION_XML)
    public Name nameAsXml(@PathParam("letter") String letter) {
        Name name = new Name();
        name.setName(nameService.alliterateOn(letter));
        return name;
    }

    @GET
    @Path("/{letter}")
    @Produces(MediaType.APPLICATION_JSON)
    public Name nameAsJson(@PathParam("letter") String letter) {
        Name name = new Name();
        name.setName(nameService.alliterateOn(letter));
        return name;
    }

    @GET
    @Path("/{letter}")
    @Produces(MediaType.TEXT_PLAIN)
    public String nameAsText(@PathParam("letter") String letter) {
        return nameService.alliterateOn(letter);
    }

    @GET
    @Path("/{letter}")
    @Produces(MediaType.TEXT_HTML)
    public Viewable nameAsHtml(@PathParam("letter") String letter) {
        String name = nameService.alliterateOn(letter);
        Map model = new HashMap<>();
        model.put("name", name);
        return new Viewable("/name.ftl", model);
    }

}
