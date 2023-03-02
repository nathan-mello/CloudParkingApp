package com.parkingCloud.cloudparking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public String hello(){
        return "Olá 3256f";
    }
}
