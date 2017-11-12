package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.entity.Author;
import ua.com.library.service.BookService;
import ua.com.library.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("users", userService.findAll());
		return "home";
	}
	
	@RequestMapping(value="/addBookToUser", method=RequestMethod.POST)
	public String home(@RequestParam String userId,
			@RequestParam String [] bookIds){

		userService.addBooksForUser(userId, bookIds);
		
		return "redirect:/home";
	}
	
	
	
}

