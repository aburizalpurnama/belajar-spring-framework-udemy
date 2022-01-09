package com.rizal.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // controller method to show initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // controller method to process and show result page
    @RequestMapping("/processForm")
    public String proccessFrom(){
        return "helloworld";
    }

    // controller method to process form using data
    @RequestMapping("/changeToUpper")
    public String changeToCapital(HttpServletRequest request, Model model){

        // get the request parameter from html form
        String name = request.getParameter("studentName");

        // convert to upper case
        name = name.toUpperCase();

        // create the mess age
        String message = "Yo! " + name;

        // add message to model
        model.addAttribute("message", message);

        return "helloworld";
    }

    // controller method to process form and get the value from request param annotation
    @RequestMapping("/changeToUpperWithRequestParam")
    public String changeToCapitalWithRequestParam(
            @RequestParam("studentName") String name, Model model){

        // convert to upper case
        name = name.toUpperCase();

        // create the mess age
        String message = "Yo! " + name + ", it's using @RequestParam";

        // add message to model
        model.addAttribute("message", message);

        return "helloworld";
    }
}
