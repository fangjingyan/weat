package ca.uwaterloo.ece651.repositories;

import ca.uwaterloo.ece651.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{

}
