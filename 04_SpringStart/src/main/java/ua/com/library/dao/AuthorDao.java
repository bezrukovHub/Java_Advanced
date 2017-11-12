package ua.com.library.dao;

import java.util.List;

import ua.com.library.entity.Author;

public interface AuthorDao {

	void save(Author author);
	List<Author> findAll();
	Author findOne(String surname);
	void delete(String surname);
	
}
