package ru.diasoft.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoubleController {

    @GetMapping("/double")
    public Integer doubleValue(@RequestParam(defaultValue = "0") Integer value) {
        return value * 2;
    }

}
