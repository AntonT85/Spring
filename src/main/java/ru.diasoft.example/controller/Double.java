package ru.diasoft.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Double {

    @GetMapping("/double")
    public Integer doubleValue(@RequestParam(required = false) String value) {
        if (value == null) {
            return 0;
        }
        return Integer.valueOf(value) * 2;
    }

}
