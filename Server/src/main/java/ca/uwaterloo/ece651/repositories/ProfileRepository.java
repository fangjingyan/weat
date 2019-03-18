package ca.uwaterloo.ece651.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.uwaterloo.ece651.models.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{
	Profile findByEmail(String email);
	List<Profile> findByUsername(String username);
	Profile findByEmailAndPassword(String email,String password);
}
