package com.hamidApp1.controller.springMvcTester;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SpringMvcTester {


    @RequestMapping(value = "/foo", method = RequestMethod.POST)
    public void processFoo(@Valid String foo){
        System.out.println("done");
    }
}
