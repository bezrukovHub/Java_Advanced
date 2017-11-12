package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.editor.BookEditor;
import ua.com.library.entity.Book;
import ua.com.library.service.BookService;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Book.class, new BookEditor(bookService));
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "views-base-home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String anton() {
		return "redirect:/";
	}

	@RequestMapping("/loginpage")
	public String login() {
		return "views-base-loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}

}
