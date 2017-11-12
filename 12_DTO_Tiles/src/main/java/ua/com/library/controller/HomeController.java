package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.service.BookService;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;

	
	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("books", DtoUtilMapper.booksToBooksDTO(bookService.findAll()));
		return "views-base-home";
	}
	
}

