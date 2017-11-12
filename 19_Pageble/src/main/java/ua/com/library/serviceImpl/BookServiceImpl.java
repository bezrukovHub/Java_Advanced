package ua.com.library.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.com.library.dao.BookDao;
import ua.com.library.entity.Book;
import ua.com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;


	@Transactional
	public void save(Book book, MultipartFile image) {
		bookDao.saveAndFlush(book);


		String path = System.getProperty("catalina.home") + "/resources/" + book.getTitle() + "/"
				+ image.getOriginalFilename();

		book.setBookImage("resources/" + book.getTitle() + "/" + image.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + book.getTitle() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}


	}

	public Book findOne(int id) {
		return bookDao.findOne(id);
	}

	public void delete(int id) {
		bookDao.delete(id);
	}

	public List<Book> sortBooks(int pages) {
		return bookDao.sortBooks(pages);
	}


	public List<Book> liveSearch(String search) {
		return bookDao.liveSearch(search);
	}


	public void save(Book book) {
		bookDao.save(book);
	}


	public List<Book> bookImages() {
		return bookDao.bookImges();
	}

	public Page<Book> findAll(int currentPage, int numberOfItem) {

		List<Book> books = bookDao.findAll();

		Pageable pageable = new PageRequest(currentPage, numberOfItem);

		return bookDao.findAll(pageable);

	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}
}
