package ca.uwaterloo.ece651.repositories;

import ca.uwaterloo.ece651.models.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long>{

}
