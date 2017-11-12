package ua.com.library.dao;

import org.springframework.transaction.annotation.Transactional;

import ua.com.library.entity.Book;

public interface BookDao extends GeneralDao<Book>{

	
	public Book findOne(String title);

	public void delete(String title);
	
	Book findBookWithUsers(String title);
	
}
