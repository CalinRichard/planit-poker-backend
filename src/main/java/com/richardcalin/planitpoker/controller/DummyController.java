package com.richardcalin.planitpoker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DummyController {

    @GetMapping
    public String getDummyText() {
        return "This is a dummy string";
    }
}
