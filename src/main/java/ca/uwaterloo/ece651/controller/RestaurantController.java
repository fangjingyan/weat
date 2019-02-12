package ca.uwaterloo.ece651.controller;

import ca.uwaterloo.ece651.model.Restaurant;
import ca.uwaterloo.ece651.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/")
    public String test() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Rest");
        restaurantRepository.save(restaurant);
        return "record inserted";
    }

    @RequestMapping("/get")
    public String test2() {
        Iterable<Restaurant> restaurants = restaurantRepository.findAll();
        for (Restaurant restaurant: restaurants) {
            System.out.println(restaurant.getName());
        }
        return "done";
    }
}
