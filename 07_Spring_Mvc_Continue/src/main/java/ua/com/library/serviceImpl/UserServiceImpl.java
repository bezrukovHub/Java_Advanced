package ua.com.library.serviceImpl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.library.dao.UserDao;
import ua.com.library.entity.User;
import ua.com.library.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(String username) {
		return userDao.findOne(username);
	}


	public void delete(String username) {
		userDao.delete(username);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public User findUserWithBooks(String username) {
		return userDao.findUserWithBooks(username);
	}

	
	
	
	
	
}