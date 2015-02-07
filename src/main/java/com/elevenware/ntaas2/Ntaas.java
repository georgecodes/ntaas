package com.elevenware.ntaas2;

import com.elevenware.ntaas2.model.Name;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Ntaas  {



    @GET
    @Path("/name")
    @Produces(MediaType.APPLICATION_XML)
    public Name nameAsXml() {
        Name name = new Name();
        name.setName("Helo");
        return name;
    }

    @GET
    @Path("/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Name nameAsJson() {
        Name name = new Name();
        name.setName("Helo");
        return name;
    }

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String nameAsText() {
        return "Helo";
    }



}
