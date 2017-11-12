package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.BookDao;
import ua.com.library.dao.UserDao;
import ua.com.library.entity.Book;
import ua.com.library.entity.User;
import ua.com.library.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao bookDao;

	public void save(User user) {
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	@Transactional
	public void addBooksForUser(String userId, String[] bookIds) {

		User user = userDao.findOne(Integer.parseInt(userId));

		for (int i = 0; i < bookIds.length; i++) {

			// user.getBooks().add(bookDao.findOne(Integer.parseInt(bookIds[i])));
			//
			// userDao.save(user);

			Book book = bookDao.findOne(Integer.parseInt(bookIds[i]));

			book.getUsers().add(user);

			bookDao.save(book);

		}

	}

}