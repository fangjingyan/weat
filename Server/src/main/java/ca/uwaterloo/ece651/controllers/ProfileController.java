package ca.uwaterloo.ece651.controllers;

/*import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import javax.crypto.Cipher;
*/
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

	@GetMapping("/home")
	public String profile() {
		return "home";
	}

	@GetMapping("/register")
	public String registration(@RequestParam(value = "Email", defaultValue = "") String email,
			@RequestParam(value = "Password", defaultValue = "") String password,
			@RequestParam(value = "Username", defaultValue = "") String username) {

		Profile profile = profileRepository.findByEmail(email);
		if (profile != null)
			return "Error: Email " + email + " exists in database!";

		profile = new Profile();

		profile.setEmail(email);
		profile.setUsername(username);
		profile.setPassword(password);

		profileRepository.save(profile);

		return "User Record Registered";
	}

	@GetMapping("/login")
	public Profile login(@RequestParam(value = "Email", defaultValue = "") String email,
			@RequestParam(value = "Password", defaultValue = "") String password) {

		Profile profile = profileRepository.findByEmailAndPassword(email, password);
		return profile;
	}

}
