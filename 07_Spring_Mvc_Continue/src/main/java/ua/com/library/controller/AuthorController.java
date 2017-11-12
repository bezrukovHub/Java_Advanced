package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.entity.Author;
import ua.com.library.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/newAuthor", method = RequestMethod.GET)
	public String newAuthor() {

		return "newAuthor";
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public String saveAuthor(@RequestParam String authorName, @RequestParam String authorSurName) {

		Author author = new Author(authorName, authorSurName);

		authorService.save(author);

		return "redirect:/newAuthor";
	}

}
