package com.ag04.pluginplatform;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p2")
public class AnotherSpringController {

    @GetMapping("/another-spring")
    public String get() {
        return "Hello from AnotherSpringController!";
    }
}
