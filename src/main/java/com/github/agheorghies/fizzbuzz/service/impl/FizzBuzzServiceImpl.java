package com.github.agheorghies.fizzbuzz.service.impl;

import com.github.agheorghies.fizzbuzz.service.FizzBuzzService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Override
    public List<String> mapRange(int begin, int end) {
        return new FizzBuzzRange().mapRange(begin, end);
    }
}
