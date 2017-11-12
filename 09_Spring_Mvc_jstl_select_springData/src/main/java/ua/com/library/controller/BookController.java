package ua.com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.entity.Book;
import ua.com.library.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public String newBook(Model model) {
		
		List<Book> booksFromDB = bookService.findAll();
		
		model.addAttribute("books", booksFromDB);
		return "newBook";
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@RequestParam String title,
			@RequestParam int pages) {
		
		Book book = new Book(title, pages);
		
		bookService.save(book);
		
		return "redirect:/newBook";
	}	
	
	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
	public String newBook(@PathVariable int id) {
		
		bookService.delete(id);
		
		return "redirect:/newBook";
	}
	
	
	
	
	
}
