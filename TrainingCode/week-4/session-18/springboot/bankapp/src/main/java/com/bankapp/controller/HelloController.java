package com.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//annotation that is used to expose rest api
public class HelloController {

    //@PathVariable vs @RequestParam
    @GetMapping(path ="hello/{uname}/{city}" )
    public String helloWorld(@PathVariable(name = "uname") String name, @PathVariable String city){
        return "hello java champ! "+ name+": "+ city;
    }

    @GetMapping(path ="hello2" )
    public String helloWorld2(@RequestParam(required = false) String start,
                              @RequestParam(required = false) String end){
        return "hello java champ! ";
    }
}
