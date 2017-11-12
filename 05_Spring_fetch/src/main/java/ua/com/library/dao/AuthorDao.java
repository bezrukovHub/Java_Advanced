package ua.com.library.dao;

import org.springframework.transaction.annotation.Transactional;

import ua.com.library.entity.Author;

public interface AuthorDao extends GeneralDao<Author>{

	public Author findOne(String surname);

	public void delete(String surname);

	Author getAuthorWithBooks(String surname);
	
}
