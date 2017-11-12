package ua.com.library.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import ua.com.library.entity.Book;

public interface BookService {

	void save(Book book);
	List<Book> findAll();
	Book findOne(int id);
	void delete(int id);

	List<Book> sortBooks(int value);

}
