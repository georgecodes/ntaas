package com.elevenware.ntaas.resources;

import com.elevenware.ntaas.model.Name;
import com.elevenware.nyaaas.NameService;
import com.elevenware.nyaaas.SimpleNameService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/name")
public class NameResource {

    private NameService nameService = new SimpleNameService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_XML)
    public Name nameAsXml() {
        Name name = new Name();
        name.setName(nameService.getAdjectiveNounPair());
        return name;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Name nameAsJson() {
        Name name = new Name();
        name.setName(nameService.getAdjectiveNounPair());
        return name;
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String nameAsText() {
        return nameService.getAdjectiveNounPair();
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public Viewable nameAsHtml() {
         String name = nameService.getAdjectiveNounPair();
         Map model = new HashMap<>();
         model.put("name", name);
         return new Viewable("/name.ftl", model);
    }

    @GET
    @Path("/number")
    @Produces(MediaType.APPLICATION_XML)
    public Name nameAsXmlNumber() {
        Name name = new Name();
        name.setName(nameService.getAdjectiveNounPair(true));
        return name;
    }

    @GET
    @Path("/number")
    @Produces(MediaType.APPLICATION_JSON)
    public Name nameAsJsonNumber() {
        Name name = new Name();
        name.setName(nameService.getAdjectiveNounPair(true));
        return name;
    }

    @GET
    @Path("/number")
    @Produces(MediaType.TEXT_PLAIN)
    public String nameAsTextNumber() {
        return nameService.getAdjectiveNounPair(true);
    }

    @GET
    @Path("/number")
    @Produces(MediaType.TEXT_HTML)
    public Viewable nameNumberAsHtml() {
        String name = nameService.getAdjectiveNounPair(true);
        Map model = new HashMap<>();
        model.put("name", name);
        return new Viewable("/name.ftl", model);
    }

}
