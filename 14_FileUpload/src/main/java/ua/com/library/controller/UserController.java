package ua.com.library.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.User;
import ua.com.library.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("userDTOs", DtoUtilMapper.usersToUsersDTO(userService.findAll()));
		model.addAttribute("user", new User());
		return "views-user-registration";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model) {

		userService.save(user);

		return "redirect:/registration";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String newUser(@PathVariable int id) {

		userService.delete(id);

		return "redirect:/registration";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {

		User user = userService.fetchUserWithBook(Integer.parseInt(principal.getName()));

		model.addAttribute("user", user);

		return "views-user-profile";
	}

	@RequestMapping(value = "/buyBook/{id}", method = RequestMethod.GET)
	public String buyBook(Principal principal, @PathVariable String id) {
		
		userService.buyBook(principal, id);

		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/deleteBookFromUser/{id}", method = RequestMethod.GET)
	public String deleteBookFromUser(Principal principal, @PathVariable String id) {
		
		userService.deleteBookFromUser(principal, Integer.parseInt(id));

		return "redirect:/profile";
	}
	
	
	
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal,
							@RequestParam MultipartFile image){

		userService.saveImage(principal, image);

		return "redirect:/profile";
	}










}
