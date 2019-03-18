package ca.uwaterloo.ece651.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.uwaterloo.ece651.models.Profile;
import ca.uwaterloo.ece651.repositories.ProfileRepository;

@RestController
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;

	@GetMapping("/testProfile")
	public String profile() {
		return "this is profile";
	}

	@GetMapping("/register")
	public String registration(@RequestParam(value = "Email", defaultValue = "") String email,
			@RequestParam(value = "Password", defaultValue = "") String password,
			@RequestParam(value = "Username", defaultValue = "") String username) {

		Profile profile = profileRepository.findByEmail(email);
		if(profile != null)
			return "Error: Email "+email+" exists in database!";
		
		profile = new Profile();
		
		profile.setEmail(email);
		profile.setUsername(username);
		profile.setPassword(password);
		
		profileRepository.save(profile);
		
		return "Profile Record Inserted";
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "Email", defaultValue = "") String email,
			@RequestParam(value = "Password", defaultValue = "") String password) {
		
		Profile profile = profileRepository.findByEmailAndPassword(email, password);
		if(profile != null)
			return profile.toString();
		return "There is no entry for the provided email and password in DB!";
	}
}
