package com.example.forrelease;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("hi")
    public void sayHello(){
        System.out.println("안녕하세요");
    }
}
