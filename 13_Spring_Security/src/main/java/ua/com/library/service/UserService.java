package ua.com.library.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.repository.query.Param;

import ua.com.library.entity.User;

public interface UserService {

	void save(User user);
	List<User> findAll();
	User findOne(int id);
	void delete(int id);
	
	void buyBook(Principal principal, String id);
	
	User fetchUserWithBook(int id);
	
	void deleteBookFromUser(Principal principal, int id);
	
}
