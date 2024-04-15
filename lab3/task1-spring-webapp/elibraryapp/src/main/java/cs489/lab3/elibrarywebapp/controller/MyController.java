package cs489.lab3.elibrarywebapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping
    public String myMethod(){
        return ("msgun");

    }
}
