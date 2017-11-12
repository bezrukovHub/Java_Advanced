package ua.com.library.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.library.entity.Author;
import ua.com.library.entity.Book;
import ua.com.library.service.AuthorService;
import ua.com.library.service.BookService;

public class Main {
	public static void main(String[] args) {

		ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("appContext.xml");
		
		BookService bookService = (BookService) context.getBean("bookService");
		
		AuthorService authorService = (AuthorService) context.getBean("authorService");
	
		bookService.save(new Book("java", 1000));
		bookService.save(new Book("c#", 200));
		bookService.save(new Book("pyton", 100));
		bookService.save(new Book("assembler", 10000));
		
		authorService.save(new Author("Stiven", "King"));
		
		
	}
}
