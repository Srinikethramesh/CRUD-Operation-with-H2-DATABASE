package com.LearnBasics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //Representational state transfer (REST)
@RequestMapping("/api/v1/")
public class HelloWorldController {
    @GetMapping("/h")
    String sayHelloWorld()
    {
        return "Hello World";
    }

}
