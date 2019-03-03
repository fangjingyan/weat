package ca.uwaterloo.ece651.repositories;

import ca.uwaterloo.ece651.enums.Category;
import ca.uwaterloo.ece651.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findByCategory(Category category);
    List<Restaurant> findByPrice(Integer price);
    List<Restaurant> findByRate(Double rate);

    List<Restaurant> findByCategoryAndPrice(Category category, Integer price);
    List<Restaurant> findByCategoryAndRate(Category category, Double rate);
    List<Restaurant> findByPriceAndRate(Integer price, Double rate);

    List<Restaurant> findByCategoryAndPriceAndRate(Category category, Integer price, Double rate);

}
