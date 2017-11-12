package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.library.dao.AuthorDao;
import ua.com.library.entity.Author;
import ua.com.library.service.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorDao authorDao;

	public void save(Author author) {
		authorDao.save(author);
	}

	public List<Author> findAll() {
		return authorDao.findAll();
	}

	public Author findOne(String surname) {
		return authorDao.findOne(surname);
	}

	public void delete(String surname) {
		authorDao.delete(surname);
	}
	
	
	
	

}
