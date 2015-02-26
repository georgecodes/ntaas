package com.elevenware.ntaas.resources;

import com.elevenware.ntaas.model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/status")
@Controller
public class StatusResource {

    @RequestMapping(produces = "application/xml", method = RequestMethod.GET)
    @ResponseBody
    public Status xmlStatus() {
        return new Status();
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Status jsonStatus() {
        return new Status();
    }


    @RequestMapping(produces = "text/html", method = RequestMethod.GET)
    @ResponseBody
    public String statusPage(Model model) {
        model.addAttribute("status", new Status());
        return "status";
    }

}
