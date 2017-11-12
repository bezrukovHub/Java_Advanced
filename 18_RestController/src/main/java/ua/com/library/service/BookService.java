package ua.com.library.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import ua.com.library.entity.Book;

public interface BookService {

	void save(Book book, MultipartFile imge);
	List<Book> findAll();
	Book findOne(int id);
	void delete(int id);

	List<Book> sortBooks(int pages);

	List<Book> liveSearch(String search);


    void save(Book book);

	List<Book> bookImges();


	List<Book> sortBookByCountry(int idCountry);

}
