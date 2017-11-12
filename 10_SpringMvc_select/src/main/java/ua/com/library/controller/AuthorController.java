package ua.com.library.controller;

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
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/newAuthor", method = RequestMethod.GET)
	public String newAuthor(Model model) {
		model.addAttribute("authors", authorService.findAuthorWithBooks());
		model.addAttribute("books", bookService.findAll());
		return "newAuthor";
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public String saveAuthor(@RequestParam String authorName,
			@RequestParam String authorSurName,
			@RequestParam String [] bookId) {

		Author author = new Author(authorName, authorSurName);

		authorService.addBookToAuthor(author, bookId);

		return "redirect:/newAuthor";
	}

	@RequestMapping(value = "/deleteAuthor/{id}", method = RequestMethod.GET)
	public String newAuthor(@PathVariable String id) {
		authorService.delete(Integer.parseInt(id));
		return "redirect:/newAuthor";
	}
	
	
	@RequestMapping(value="/deleteBookFromAuthor/{idBook}")
	public String deleteBookFromAuthor(@PathVariable String idBook){
		
		authorService.deleteBookFromAuthor(idBook);
		
		return "redirect:/newAuthor";
	}

	
	
	
}
