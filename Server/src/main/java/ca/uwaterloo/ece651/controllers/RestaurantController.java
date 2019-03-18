package ca.uwaterloo.ece651.controllers;

import ca.uwaterloo.ece651.enums.Category;
import ca.uwaterloo.ece651.models.Restaurant;
import ca.uwaterloo.ece651.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/load_restaurants")
    public String loadRestaurants() {
        Restaurant restaurant = new Restaurant();

        restaurant.setName("Kabob Hut");
        restaurant.setCategory(Category.OTHERS);
        restaurant.setPrice(2);
        restaurant.setRate(4.4);
        restaurantRepository.save(restaurant);

        restaurant.setName("Waterloo Star");
        restaurant.setCategory(Category.CHINESE);
        restaurant.setPrice(1);
        restaurant.setRate(3.6);
        restaurantRepository.save(restaurant);

        restaurant.setName("River and Lake Best Food House");
        restaurant.setCategory(Category.CHINESE);
        restaurant.setPrice(1);
        restaurant.setRate(3.2);
        restaurantRepository.save(restaurant);

        restaurant.setName("Seoul Seoul");
        restaurant.setCategory(Category.KOREAN);
        restaurant.setPrice(1);
        restaurant.setRate(2.5);
        restaurantRepository.save(restaurant);

        return "Restaurant Records Inserted";
    }

    @RequestMapping("/restaurant")
    public List<Restaurant> getRestaurants(@RequestParam(value = "Category", defaultValue = "") String category,
                               @RequestParam(value = "Price", defaultValue = "") String price,
                               @RequestParam(value = "Rating", defaultValue = "") String rate) {
        Category c = null;
        Integer p = 0;
        Double r = 0.0;
        List<Restaurant> result = null;

        if (!category.equals("")) {
            if (category.equals("Chinese")) {
                c = Category.CHINESE;
            }
            else if (category.equals("Korean")) {
                c = Category.KOREAN;
            }
            else if (category.equals("Japanese")) {
                c = Category.JAPANESE;
            }
            else if (category.equals("Western")) {
                c = Category.WESTERN;
            }
            else if (category.equals("Fastfood")) {
                c = Category.FASTFOOD;
            }
            else if (category.equals("Others")) {
                c = Category.OTHERS;
            }
        }

        if (!price.equals("")) {
            p = Integer.valueOf(price);
        }

        if (!rate.equals("")) {
            r = Double.valueOf(rate);
        }

        if (c != null && p != 0 && r != 0.0) {
            result = restaurantRepository.findByCategoryAndPriceAndRate(c, p, r);
        }
        else if (c != null && p != 0) {
            result = restaurantRepository.findByCategoryAndPrice(c, p);
        }
        else if (c != null && r != 0.0) {
            result = restaurantRepository.findByCategoryAndRate(c, r);
        }
        else if (p != 0 && r != 0.0) {
            result = restaurantRepository.findByPriceAndRate(p, r);
        }
        else if (c != null) {
            result = restaurantRepository.findByCategory(c);
        }
        else if (p != 0) {
            result = restaurantRepository.findByPrice(p);
        }
        else if (r != 0.0) {
            result = restaurantRepository.findByRate(r);
        }

        return result;
    }
}
