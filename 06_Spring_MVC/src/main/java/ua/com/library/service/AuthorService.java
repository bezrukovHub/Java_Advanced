package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Author;

public interface AuthorService {

	void save(Author author);
	List<Author> findAll();
	Author findOne(String surname);
	void delete(String surname);
	Author getAuthorWithBooks(String surname); 
	
}
