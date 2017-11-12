package ua.com.library.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.library.dao.BookDao;
import ua.com.library.entity.Book;
import ua.com.library.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;

	public void save(Book book) {
		bookDao.save(book);
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public Book findOne(String title) {
		return bookDao.findOne(title);
	}

	public void delete(String title) {
		bookDao.delete(title);
	}

	public void update(Book book) {
		bookDao.update(book);
	}

	public Book findBookWithUsers(String title) {
		return bookDao.findBookWithUsers(title);
	}

}
