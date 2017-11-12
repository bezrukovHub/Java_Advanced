package ua.com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.entity.Author;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		
		return "home";
	}
}

