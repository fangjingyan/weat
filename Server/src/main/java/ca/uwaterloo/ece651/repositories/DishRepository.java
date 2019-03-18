package ca.uwaterloo.ece651.repositories;


import ca.uwaterloo.ece651.models.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long>{
	List<Dish> findByIngredientsLike(String ingredients);
}
