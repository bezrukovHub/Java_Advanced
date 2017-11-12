package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.User;

public interface UserService {

	void save(User user);
	List<User> findAll();
	User findOne(String username);
	void delete(String username);
	void update(User user);
	User findUserWithBooks(String username);
	
}
