package com.elevenware.ntaas.resources;

import com.elevenware.ntaas.model.Name;
import com.elevenware.nyaaas.NameService;
import com.elevenware.nyaaas.SimpleNameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/alliteration")
@Controller
public class AlliterationResource {

    private NameService nameService = new SimpleNameService();

    @RequestMapping(value = "/{letter}", produces = "application/xml", method = RequestMethod.GET)
    @ResponseBody
    public Name nameAsXml(@PathVariable("letter") String letter) {
        Name name = new Name();
        name.setName(nameService.alliterateOn(letter));
        return name;
    }

    @RequestMapping(value = "/{letter}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Name nameAsJson(@PathVariable("letter") String letter) {
        Name name = new Name();
        name.setName(nameService.alliterateOn(letter));
        return name;
    }

    @RequestMapping(value = "/{letter}", produces = "text/plain", method = RequestMethod.GET)
    @ResponseBody
    public String nameAsText(@PathVariable("letter") String letter) {
        return nameService.alliterateOn(letter);
    }

    @RequestMapping(value = "/{letter}", produces = "text/html", method = RequestMethod.GET)
    public String nameAsHtml(@PathVariable("letter") String letter, Model model) {
        String name = nameService.alliterateOn(letter);
        model.addAttribute("name", name);
        return "name";
    }

    @RequestMapping(value = "/{letter}/number", produces = "application/xml", method = RequestMethod.GET)
    @ResponseBody
    public Name nameAsXmlWithNumber(@PathVariable("letter") String letter) {
        Name name = new Name();
        name.setName(nameService.alliterateOn(letter, true));
        return name;
    }

    @RequestMapping(value = "/{letter}/number", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Name nameAsJsonWithNumber(@PathVariable("letter") String letter) {
        Name name = new Name();
        name.setName(nameService.alliterateOn(letter, true));
        return name;
    }

    @RequestMapping(value = "/{letter}/number", produces = "text/plain", method = RequestMethod.GET)
    @ResponseBody
    public String nameAsTextWithNumber(@PathVariable("letter") String letter) {
        return nameService.alliterateOn(letter, true);
    }

    @RequestMapping(value = "/{letter}/number", produces = "text/html", method = RequestMethod.GET)
    public String nameAsHtmlWithNumber(@PathVariable("letter") String letter, Model model) {
        String name = nameService.alliterateOn(letter, true);
        model.addAttribute("name", name);
        return "name";
    }

}
