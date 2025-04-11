package com.example.SpringOuth2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrincipalController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello WOrd";
    }
    @GetMapping("/helloWithSecurity")
    public String HelloWithSecurity(){
        return "Hello with security";
    }
}
