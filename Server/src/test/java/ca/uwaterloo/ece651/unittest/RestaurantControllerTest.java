package ca.uwaterloo.ece651.unittest;

import ca.uwaterloo.ece651.controllers.RestaurantController;
import ca.uwaterloo.ece651.enums.Category;
import ca.uwaterloo.ece651.models.Restaurant;
import ca.uwaterloo.ece651.repositories.RestaurantRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class RestaurantControllerTest {

    private static RestaurantRepository restaurantRepository = mock(RestaurantRepository.class);

    @InjectMocks
    private RestaurantController restaurantController;

    @BeforeClass
    public static void init() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId(1L);
        restaurant1.setName("testRestaurant1");
        restaurant1.setPrice(3);
        restaurant1.setRate(4.0);
        restaurant1.setCategory(Category.CHINESE);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setId(2L);
        restaurant2.setName("testRestaurant2");
        restaurant2.setPrice(1);
        restaurant2.setRate(3.0);
        restaurant2.setCategory(Category.CHINESE);

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setId(3L);
        restaurant3.setName("testRestaurant3");
        restaurant3.setPrice(2);
        restaurant3.setRate(3.5);
        restaurant3.setCategory(Category.AMERICAN);

        Restaurant restaurant4 = new Restaurant();
        restaurant4.setId(4L);
        restaurant4.setName("testRestaurant4");
        restaurant4.setPrice(2);
        restaurant4.setRate(4.2);
        restaurant4.setCategory(Category.MIDDLEEAST);

        when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant1, restaurant2, restaurant3, restaurant4));

        when(restaurantRepository.findByCategory(Category.CHINESE)).thenReturn(Arrays.asList(restaurant1, restaurant2));
        when(restaurantRepository.findByPrice(3)).thenReturn(Arrays.asList(restaurant1));
        when(restaurantRepository.findByRate(4.0)).thenReturn(Arrays.asList(restaurant1, restaurant4));

        when(restaurantRepository.findByCategoryAndPrice(Category.AMERICAN, 2)).thenReturn(Arrays.asList(restaurant3));
        when(restaurantRepository.findByCategoryAndRate(Category.CHINESE, 3.0)).thenReturn(Arrays.asList(restaurant1, restaurant2));
        when(restaurantRepository.findByPriceAndRate(2, 3.0)).thenReturn(Arrays.asList(restaurant3, restaurant4));

        when(restaurantRepository.findByCategoryAndPriceAndRate(Category.CHINESE, 3, 4.0)).thenReturn(Arrays.asList(restaurant1));
    }

    @Test
    public void testGetRestaurantsOne() {
        List<Restaurant> result = restaurantController.getRestaurants("", "", "");
        assertEquals(4, result.size());
    }

    @Test
    public void testGetRestaurantsTwo() {
        List<Restaurant> result = restaurantController.getRestaurants("Chinese", "", "");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetRestaurantsThree() {
        List<Restaurant> result = restaurantController.getRestaurants("", "3", "");
        assertEquals(1, result.size());
    }

    @Test
    public void testGetRestaurantsFour() {
        List<Restaurant> result = restaurantController.getRestaurants("", "", "3");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetRestaurantsFive() {
        List<Restaurant> result = restaurantController.getRestaurants("American", "2", "");
        assertEquals(1, result.size());
    }

    @Test
    public void testGetRestaurantsSix() {
        List<Restaurant> result = restaurantController.getRestaurants("Chinese", "", "2");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetRestaurantsSeven() {
        List<Restaurant> result = restaurantController.getRestaurants("", "2", "2");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetRestaurantsEight() {
        List<Restaurant> result = restaurantController.getRestaurants("Chinese", "3", "3");
        assertEquals(1, result.size());
    }
}
