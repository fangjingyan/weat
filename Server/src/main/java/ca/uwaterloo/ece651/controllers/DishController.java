package ca.uwaterloo.ece651.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.uwaterloo.ece651.models.Dish;
import ca.uwaterloo.ece651.repositories.DishRepository;


@RestController
public class DishController {
	
	 @Autowired
	 private DishRepository dishRepository;
	 
	 @RequestMapping("/dish")
	 public List<Dish> getDishs(@RequestParam(value = "Pork", defaultValue = "_") String pork,
             @RequestParam(value = "Beef", defaultValue = "_") String beef,
             @RequestParam(value = "Fish", defaultValue = "_") String fish,
             @RequestParam(value = "Mutton", defaultValue = "_") String mutton,
             @RequestParam(value = "Chicken", defaultValue = "_") String chicken,
             @RequestParam(value = "Egg", defaultValue = "_") String egg,
             @RequestParam(value = "Potato", defaultValue = "_") String potato,
             @RequestParam(value = "Tomato", defaultValue = "_") String tomato,
             @RequestParam(value = "Cabbage", defaultValue = "_") String cabbage,
             @RequestParam(value = "Onion", defaultValue = "_") String onion,
             @RequestParam(value = "Spinach", defaultValue = "_") String spinach,
             @RequestParam(value = "Green_pepper", defaultValue = "_") String green_pepper,
             @RequestParam(value = "Corn", defaultValue = "_") String corn,
             @RequestParam(value = "Broccoli", defaultValue = "_") String broccoli,
             @RequestParam(value = "Dou_fu", defaultValue = "_") String douFu
			 )
	 {
		 List<Dish> result = null;
		 String ingredients = null;
		 
		 if(pork.equals("Pork")){
			 pork = "1";
		 }
         if(beef.equals("Beef")){
        	 beef = "1";
		 }
         if(fish.equals("Fish")){
        	 fish = "1";
		 }
         if(pork.equals("Mutton")){
        	 pork = "1";
		 }
         if(mutton.equals("Chicken")){
        	 mutton = "1";
		 }
         if(egg.equals("Egg")){
        	 egg = "1";
      	 }
         if(potato.equals("Potato")){
        	 potato = "1";
      	 }
         if(tomato.equals("Tomato")){
        	 tomato = "1";
      	 }
         if(cabbage.equals("Cabbage")){
        	 cabbage = "1";
      	 }
         if(onion.equals("Onion")){
        	 onion = "1";
      	 }
         if(spinach.equals("Spinach")){
        	 spinach = "1";
      	 }
         if(green_pepper.equals("Green_pepper")){
        	 green_pepper = "1";
      	 }
         if(corn.equals("Corn")){
        	 corn = "1";
      	 }
         if(broccoli.equals("Broccoli")){
        	 broccoli = "1";
		 }
         if(douFu.equals("Dou_fu")){
        	 douFu = "1";
		 }
         
		 ingredients = pork + beef + fish +mutton + chicken + egg + potato + tomato + cabbage + onion + spinach + green_pepper + corn+broccoli + douFu;
		 result = dishRepository.findByIngredientsLike(ingredients);
		 return result;
		 
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

	 