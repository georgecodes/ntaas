package com.elevenware.ntaas.resources;

import com.elevenware.ntaas.model.Name;
import com.elevenware.nyaaas.NameService;
import com.elevenware.nyaaas.SimpleNameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/name")
@Controller
public class NameResource {

    private NameService nameService = new SimpleNameService();

    @RequestMapping(produces = "application/xml", method = RequestMethod.GET)
    @ResponseBody
    public Name nameAsXml() {
        Name name = new Name();
        name.setName(nameService.getAdjectiveNounPair());
        return name;
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Name nameAsJson() {
        Name name = new Name();
        name.setName(nameService.getAdjectiveNounPair());
        return name;
    }

    @RequestMapping(produces = "text/plain", method = RequestMethod.GET)
    @ResponseBody
    public String nameAsText() {
        return nameService.getAdjectiveNounPair();
    }

    @RequestMapping(produces = "text/html", method = RequestMethod.GET)
    public String nameAsHtml(Model model) {
         String name = nameService.getAdjectiveNounPair();
         model.addAttribute("name", name);
        return "name";
    }

    @RequestMapping(value = "/number", produces = "application/xml", method = RequestMethod.GET)
    @ResponseBody
    public Name nameAsXmlNumber() {
        Name name = new Name();
        name.setName(nameService.getAdjectiveNounPair(true));
        return name;
    }

    @RequestMapping(value = "/number", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Name nameAsJsonNumber() {
        Name name = new Name();
        name.setName(nameService.getAdjectiveNounPair(true));
        return name;
    }

    @RequestMapping(value = "/number", produces = "text/plain", method = RequestMethod.GET)
    @ResponseBody
    public String nameAsTextNumber() {
        return nameService.getAdjectiveNounPair(true);
    }

    @RequestMapping(value = "/number", produces = "text/html", method = RequestMethod.GET)
    public String nameNumberAsHtml(Model model) {
        String name = nameService.getAdjectiveNounPair(true);
        model.addAttribute("name", name);
        return "name";
    }

}
