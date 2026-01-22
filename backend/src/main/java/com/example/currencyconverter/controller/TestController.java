package com.example.currencyconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/health")
    public String healthCheck(){
        return "Currency Converter API is running";
    }
}
