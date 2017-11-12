package ua.com.library.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import ua.com.library.entity.Book;

public interface BookService {

	List<Book> findAll();

	Page<Book> findAll(int currentPage, int numberOfItem);

	void save(Book book, MultipartFile imge);
	Book findOne(int id);
	void delete(int id);

	List<Book> sortBooks(int pages);

	List<Book> liveSearch(String search);


    void save(Book book);

	List<Book> bookImages();

}
