package com.example.forrelease;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class HiController {

    @GetMapping("/helloWorld/{hiStr}")
    @ResponseBody
    public String getHi(
        @PathVariable String hiStr
    ) {
        return "hello "+hiStr;
    }

}
