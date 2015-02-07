package com.elevenware.ntaas;

import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;
import org.glassfish.jersey.test.JerseyTest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class ViewTests extends AbstractNtaasApplicationTests {

    @Test
    public void frontPageExists() {

        Document document = browseTo("");

        assertNotNull(document);

        Element intro = document.select("div.content p").first();
        assertEquals(intro.text(), "Inspired by Heroku's naming convention, this web service will generate random names for your applications.");

    }

    private Document browseTo(String path) {
        String response = target(path).request().accept(MediaType.TEXT_HTML).get(String.class);
        return Jsoup.parse(response);
    }


}
