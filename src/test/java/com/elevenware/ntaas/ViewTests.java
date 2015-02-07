package com.elevenware.ntaas;

import org.glassfish.jersey.test.JerseyTest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class ViewTests extends AbstractNtaasApplicationTests {

    @Test
    public void frontPageExists() {

        Document document = browseTo("");

        assertNotNull(document);

    }

    private Document browseTo(String path) {
        Response response = target(path).request().accept(MediaType.TEXT_HTML).get();
        return Jsoup.parse("");
    }


}
