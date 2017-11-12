package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String newBook() {

		return "newBook";
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@RequestParam String title,
			@RequestParam int pages) {
		
		Book book = new Book(title, pages);
		
		bookService.save(book);
		
		return "newBook";
	}	
	
	
	
	
	
	
	
}
