package ca.uwaterloo.ece651.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantControlller {

    @RequestMapping("/")
    public String hello() {
        return "hello world";
    }
}
