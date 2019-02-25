package ca.uwaterloo.ece651.repositories;

import ca.uwaterloo.ece651.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findByName(String name);
}
