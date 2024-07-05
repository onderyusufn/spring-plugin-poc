package com.ag04.pluginplatform;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p1")
public class SpringController {

    @GetMapping("/spring")
    public String get() {
        return "Hello from SpringController!";
    }
}
