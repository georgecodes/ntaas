package com.elevenware.ntaas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontPageController {
    
    @RequestMapping( value = "/", method = RequestMethod.GET, produces = "text/html")
    public String frontPage() {
        return "index.html";
    }
    
}
