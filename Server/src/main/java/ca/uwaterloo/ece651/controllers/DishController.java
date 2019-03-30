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
	 public List<Dish> getDishs( @RequestParam(value = "Meat", defaultValue = "") String meat,
             @RequestParam(value = "Vegetable", defaultValue = "") String vegetable)
	 {
		 List<Dish> result = null;
		 String ingredients = null;
		
		 String pork = "_";
		 String beef = "_";
		 String fish = "_";
		 String mutton = "_";
		 String chicken = "_";
		 String egg = "_";
		 String potato = "_";
		 String tomato = "_";
		 String cabbage = "_";
		 String onion = "_";
		 String spinach = "_";
		 String green_pepper = "_";
		 String corn = "_";
		 String broccoli = "_";
		 String douFu ="_";
		 
		 if (meat!="") {
			 String[] meats =  meat.split(",");
			 for (int i=0; i < meats.length; i++) {
				 
				 if(meats[i].equals("Pork")){
					 pork = "1";
				 }
		         if(meats[i].equals("Beef")){
		        	 beef = "1";
				 }
		         if(meats[i].equals("Fish")){
		        	 fish = "1";
				 }
		         if(meats[i].equals("Mutton")){
		        	 mutton = "1";
				 }
		         if(meats[i].equals("Chicken")){
		        	 chicken = "1";
				 }
		         if(meats[i].equals("Egg")){
		        	 egg = "1";
		      	 }
			 }			 
		 }	 
		 
		 
		 if (vegetable!="") {
			 String[] vegetables = vegetable.split(",");
			 for (int i=0; i < vegetables.length; i++) {
				 
				 if(vegetables[i].equals("Potato")){
		        	 potato = "1";
		      	 }
		         if(vegetables[i].equals("Tomato")){
		        	 tomato = "1";
		      	 }
		         if(vegetables[i].equals("Cabbage")){
		        	 cabbage = "1";
		      	 }
		         if(vegetables[i].equals("Onion")){
		        	 onion = "1";
		      	 }
		         if(vegetables[i].equals("Spinach")){
		        	 spinach = "1";
		      	 }
		         if(vegetables[i].equals("Green_pepper")){
		        	 green_pepper = "1";
		      	 }
		         if(vegetables[i].equals("Corn")){
		        	 corn = "1";
		      	 }
		         if(vegetables[i].equals("Broccoli")){
		        	 broccoli = "1";
				 }
		         if(vegetables[i].equals("Dou_fu")){
		        	 douFu = "1";
				 }		 
			 }			 
		 }	 
	       
		 ingredients = pork + beef + fish + mutton + chicken + egg + potato + tomato + cabbage + onion + spinach + green_pepper + corn + broccoli + douFu;
		 result = dishRepository.findByIngredientsLike(ingredients);
		 return result;
		 
	 }
}

	 