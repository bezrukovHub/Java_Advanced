package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.entity.User;
import ua.com.library.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());
		return "newUser";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user) {

		userService.save(user);
		
		return "redirect:/newUser";
	}
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String newUser(@PathVariable int id) {

		userService.delete(id);
		
		return "redirect:/newUser";
	}
	
	
	
	
	
}
