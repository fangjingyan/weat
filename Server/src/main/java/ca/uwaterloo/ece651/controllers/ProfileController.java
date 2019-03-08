package ca.uwaterloo.ece651.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
//	@Autowired
//	 private ProfileRepository profileRepository;
	
	@GetMapping("/testProfile")
	public String profile() {
	 	return "this is profile";
	 }

	
	
	@RequestMapping("/profile")
	public String getProfiles(@RequestParam(value = "Email", defaultValue = "") String email,
             @RequestParam(value = "Password", defaultValue = "") String password, @RequestParam(value = "Nickname", defaultValue = "") String nickname) {
		
		return "Hi "+ email + " " + password + "" + nickname; 
	
	}
//	
}
