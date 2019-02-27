package ca.uwaterloo.ece651.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.uwaterloo.ece651.models.Dish;
import ca.uwaterloo.ece651.repositories.DishRepository;


@RestController
public class DishController {
	
	 @Autowired
	 private DishRepository dishRepository;
	 
	 @RequestMapping("/dish")
	    public String Dish() {
	        return "this is dish";
	    }
	 
	 @RequestMapping("/")
	 public String test3() {
		 Dish dish = new Dish();
		 dish.setName("Test dish");
		 dishRepository.save(dish);
		 return "dish inserted";
	 }	 
	@RequestMapping("/get")	 
	 public String test4() {
        Iterable<Dish> dishes = dishRepository.findAll();
        for (Dish dish: dishes) {
            System.out.println(dish.getName());
        }
        return "done";
	 }
	
}
