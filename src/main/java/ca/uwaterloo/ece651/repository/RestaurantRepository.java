package ca.uwaterloo.ece651.repository;

import ca.uwaterloo.ece651.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findByName(String name);
}
