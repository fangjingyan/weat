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

	@GetMapping("/register")
	public int registration(@RequestParam(value = "Email", defaultValue = "") String email,
			@RequestParam(value = "Password", defaultValue = "") String password,
			@RequestParam(value = "Username", defaultValue = "") String username) {

		Profile profile = profileRepository.findByEmail(email);
		if (profile != null)
			return 0;

		profile = new Profile();

		profile.setEmail(email);
		profile.setUsername(username);
		profile.setPassword(password);

		profileRepository.save(profile);

		return 1;
	}

	@GetMapping("/login")
	public Profile login(@RequestParam(value = "Email", defaultValue = "") String email,
			@RequestParam(value = "Password", defaultValue = "") String password) {

		Profile profile = profileRepository.findByEmailAndPassword(email, password);
		return profile;
	}

}
