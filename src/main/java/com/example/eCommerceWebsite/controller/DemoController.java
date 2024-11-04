package com.example.eCommerceWebsite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ty")
public class DemoController {
    @GetMapping("/demo")
public String demo(){
    return "Hello World";
}
}
