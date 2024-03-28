package com.example.forrelease;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HiController {

    private final HiService hiService;

    @PatchMapping("helloWorld/{hiStr}")
    public void createHi(
        @PathVariable String hiStr
    ) {
        hiService.createHi(hiStr);
    }

    @GetMapping("helloWorld/{hiStr}")
    public List<Hi> getHi(
        @PathVariable String hiStr
    ) {
        return hiService.getHi(hiStr);
    }

}
