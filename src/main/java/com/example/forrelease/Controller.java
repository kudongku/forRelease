package com.example.forrelease;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("helloWorld")
    @ResponseBody
    public String helloWorld() {
        System.out.println("helloWorld");
        return "helloWorld";
    }
}
