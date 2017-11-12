package ua.com.library.service;

import java.security.Principal;
import java.util.List;

import ua.com.library.entity.User;

public interface UserService {

	void save(User user) throws Exception;
	List<User> findAll();
	User findOne(int id);
	void delete(int id);
	
	void buyBook(Principal principal, String id);
	
}
