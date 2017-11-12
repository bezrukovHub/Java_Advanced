package ua.com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.entity.Author;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model){
	
		model.addAttribute("key", new Author("some", "some"));
		
		return "home";
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUp(Model model){
	
		model.addAttribute("key", new Author("some", "some"));
		
		return "signUp";
	}
	
	
}

