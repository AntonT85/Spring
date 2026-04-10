package ru.diasoft.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.example.aspect.annotation.Loggable;

@RestController
public class DoubleController {

    @GetMapping("/double")
    @Loggable
    public Integer doubleValue(@RequestParam(defaultValue = "0") Integer value) {
        return value * 2;
    }

}
