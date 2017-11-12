package ua.com.library.controller;

import org.hibernate.Hibernate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.library.entity.Author;
import ua.com.library.entity.Book;
import ua.com.library.entity.User;
import ua.com.library.service.AuthorService;
import ua.com.library.service.BookService;
import ua.com.library.service.UserService;

public class Main {
	public static void main(String[] args) {

		ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("appContext.xml");
		
		BookService bookService = (BookService) context.getBean("bookService");
				
		Book book = bookService.findBookWithUsers("assembler");
		
		System.out.println(book.getUsers());
		
//		AuthorService authorService = (AuthorService) context.getBean("authorService");
//		
//		UserService userService = (UserService) context.getBean("userService");
	
//		bookService.save(new Book("java", 1000));
//		bookService.save(new Book("c#", 200));
//		bookService.save(new Book("pyton", 100));
//		bookService.save(new Book("assembler", 10000));
//		
//		authorService.save(new Author("Stiven", "King"));
		
//		Author author = authorService.getAuthorWithBooks("King");
//		
//		book.setAuthor(author);
//		
//		bookService.update(book);

//		System.out.println(author.getBooks());
		
//		userService.save(new User("koko", "shorobura.mukola@gmail.com", "koko", "+380989783447"));
		
//		User user = userService.findUserWithBooks("koko");
//		
//		user.getBooks().add(book);
//		
//		userService.update(user);
		
		
	}
}
