package dev.larrybattle.cordview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hi")
    public String index(){
        return "Hello World";
    }
}
