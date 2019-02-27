package ca.uwaterloo.ece651.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	@RequestMapping("/")
	public String profile(){
        return "This is profile";
    }
}
