package ua.com.library.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ua.com.library.entity.User;

public interface UserDao extends GeneralDao<User>{

	public User findOne(String username);
	public void delete(String username);
	
	User findUserWithBooks(String username);
	
}
