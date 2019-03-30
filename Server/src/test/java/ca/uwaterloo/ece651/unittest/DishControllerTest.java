package ca.uwaterloo.ece651.unittest;

import ca.uwaterloo.ece651.controllers.DishController;
import ca.uwaterloo.ece651.enums.Category;
import ca.uwaterloo.ece651.models.Dish;
import ca.uwaterloo.ece651.repositories.DishRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DishControllerTest {
	
	 private static DishRepository dishRepository = mock(DishRepository.class);
	 
	 @InjectMocks
	 private DishController dishController;

	 @BeforeClass
	 public static void init() {
		 Dish dish1 = new Dish();
		 dish1.setId(1L);
		 dish1.setName("testDish1");
		 dish1.setCategory(Category.CHINESE);
		 dish1.setIngredients("111111111111111");
		 
		 
		 Dish dish2 = new Dish();
		 dish1.setId(2L);
		 dish1.setName("testDish2");
		 dish1.setCategory(Category.JANDK);
		 dish1.setIngredients("111111000000000");
		 
		 Dish dish3 = new Dish();
		 dish1.setId(3L);
		 dish1.setName("testDish3");
		 dish1.setCategory(Category.EUROPEAN);
		 dish1.setIngredients("000000111111111");
		 
		 when(dishRepository.findByIngredientsLike("_______________")).thenReturn(Arrays.asList(dish1,dish2,dish3));
	     when(dishRepository.findByIngredientsLike("111111_________")).thenReturn(Arrays.asList(dish1,dish2));
		 when(dishRepository.findByIngredientsLike("______111111111")).thenReturn(Arrays.asList(dish1,dish3));
		 when(dishRepository.findByIngredientsLike("111111111111111")).thenReturn(Arrays.asList(dish1));
	 }
	 
	 @Test
	 public void testGetDishsOne() {
	     List<Dish> result = dishController.getDishs("", "");
	     assertEquals(3, result.size());
	 }
	    
	 @Test
	 public void testGetDishsTwo() {
	     List<Dish> result = dishController.getDishs("Pork,Beef,Fish,Mutton,Chicken,Egg", "");
	     assertEquals(2, result.size());
	 }
	 
	 @Test
	 public void testGetDishsThree() {
	     List<Dish> result = dishController.getDishs("", "Potato,Tomato,Cabbage,Onion,Spinach,Green_pepper,Corn,Broccoli,Dou_fu");
	     assertEquals(2, result.size());
	 } 
	 
	 @Test
	 public void testGetDishsFour() {
	     List<Dish> result = dishController.getDishs("Pork,Beef,Fish,Mutton,Chicken,Egg", "Potato,Tomato,Cabbage,Onion,Spinach,Green_pepper,Corn,Broccoli,Dou_fu");
	     assertEquals(1, result.size());
	 }
}