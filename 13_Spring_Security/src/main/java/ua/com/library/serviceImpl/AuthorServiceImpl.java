package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.AuthorDao;
import ua.com.library.dao.BookDao;
import ua.com.library.entity.Author;
import ua.com.library.entity.Book;
import ua.com.library.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private BookDao bookDao;

	public void save(Author author) {
		authorDao.save(author);
	}

	public List<Author> findAll() {
		return authorDao.findAll();
	}

	public Author findOne(int id) {
		return authorDao.findOne(id);
	}
	public List<Author> findAuthorWithBooks() {
		return authorDao.findAuthorWithBook();
	}

	@Transactional
	public void delete(int id) {
		Author author = authorDao.findAuthorWithBook(id);
		
		for(Book book : author.getBooks()){
			book.setAuthor(null);
			bookDao.save(book);
		}
		
		authorDao.delete(author);
		
	}

	
	
	public void saveAndFlush(Author author) {
		authorDao.saveAndFlush(author);
	}

	
	
	@Transactional
	public void deleteBookFromAuthor(String idBook) {
		
		Book book = bookDao.findOne(Integer.parseInt(idBook));
		
		book.setAuthor(null);
		
		bookDao.save(book);
	}



}
