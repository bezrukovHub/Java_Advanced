package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.entity.User;
import ua.com.library.service.AuthorService;
import ua.com.library.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser() {

		return "newUser";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam String username,
			@RequestParam String email,
			@RequestParam String pass,
			@RequestParam String phone) {

		User user = new User(username, email, pass, phone);
		
		userService.save(user);
		
		return "redirect:/newUser";
	}
	
}
