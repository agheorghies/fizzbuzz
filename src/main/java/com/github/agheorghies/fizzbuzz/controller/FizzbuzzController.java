package com.github.agheorghies.fizzbuzz.controller;

import com.github.agheorghies.fizzbuzz.service.FizzBuzzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzbuzzController {
    private FizzBuzzService fizzBuzzService;

    public FizzbuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping
    public List<String> getFizzbuzzForRange(@RequestParam("begin") Integer begin, @RequestParam("end") Integer end) {
        return fizzBuzzService.mapRange(begin, end);
    }

}
