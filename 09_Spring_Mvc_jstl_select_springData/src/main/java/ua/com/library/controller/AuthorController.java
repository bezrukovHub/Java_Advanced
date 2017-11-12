package ua.com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.entity.Author;
import ua.com.library.entity.Book;
import ua.com.library.service.AuthorService;
import ua.com.library.service.BookService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	

	@RequestMapping(value = "/newAuthor", method = RequestMethod.GET)
	public String newAuthor(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return "newAuthor";
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public String saveAuthor(@RequestParam String authorName, @RequestParam String authorSurName) {

		Author author = new Author(authorName, authorSurName);

		authorService.save(author);

		return "redirect:/newAuthor";
	}

	
	@RequestMapping(value = "/deleteAuthor/{id}", method = RequestMethod.GET)
	public String newAuthor(@PathVariable String id) {
		authorService.delete(Integer.parseInt(id));
		return "redirect:/newAuthor";
	}
	
	
	

	
	
	
}
