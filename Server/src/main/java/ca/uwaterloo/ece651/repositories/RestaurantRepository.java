package ca.uwaterloo.ece651.repositories;

import ca.uwaterloo.ece651.enums.Category;
import ca.uwaterloo.ece651.models.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findByCategory(Category category);
    List<Restaurant> findByPrice(Integer price);
    @Query("SELECT r FROM Restaurant r WHERE r.rate >= ?1")
    List<Restaurant> findByRate(Double rate);

    List<Restaurant> findByCategoryAndPrice(Category category, Integer price);
    @Query("SELECT r FROM Restaurant r WHERE r.category = ?1 AND r.rate >= ?2")
    List<Restaurant> findByCategoryAndRate(Category category, Double rate);
    @Query("SELECT r FROM Restaurant r WHERE r.price = ?1 AND r.rate >= ?2")
    List<Restaurant> findByPriceAndRate(Integer price, Double rate);

    @Query("SELECT r FROM Restaurant r WHERE r.category = ?1 AND r.price = ?2 AND r.rate >= ?3")
    List<Restaurant> findByCategoryAndPriceAndRate(Category category, Integer price, Double rate);
    List<Restaurant> findAll();
}
