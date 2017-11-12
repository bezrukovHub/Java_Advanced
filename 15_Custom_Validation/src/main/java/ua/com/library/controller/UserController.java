package ua.com.library.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.User;
import ua.com.library.service.UserService;
import ua.com.library.validator.UserValidationMessages;

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
		
		try {
			userService.save(user);
		} catch (Exception e) {
			if(e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD)||
					e.getMessage().equals(UserValidationMessages.NAME_ALREADY_EXIST)){
				model.addAttribute("usernameException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessages.EMPTY_EMAIl_FIELD )||
					e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)){
				model.addAttribute("emailException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("passwordException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessages.EMPTY_PHONE_FIELD) ||
					e.getMessage().equals(UserValidationMessages.PHONE_ALREADY_EXIST)){
				model.addAttribute("phoneException", e.getMessage());
			}
			return "views-user-registration";
		}
		
		return "redirect:/registration";
	}
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String newUser(@PathVariable int id) {

		userService.delete(id);
		
		return "redirect:/registration";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {
		
		System.out.println(principal);
		
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		
		model.addAttribute("user", user);
		
		return "views-user-profile";
	}
	
	
	@RequestMapping(value = "/buyBook/{id}", method = RequestMethod.GET)
	public String buyBook(Principal principal, @PathVariable String id) {
		
		userService.buyBook(principal, id);
		
		return "redirect:/";
	}
	
	
}
