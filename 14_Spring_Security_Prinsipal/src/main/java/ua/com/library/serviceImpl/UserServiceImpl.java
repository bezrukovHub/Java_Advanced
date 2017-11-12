package ua.com.library.serviceImpl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.BookDao;
import ua.com.library.dao.UserDao;
import ua.com.library.entity.Book;
import ua.com.library.entity.Role;
import ua.com.library.entity.User;
import ua.com.library.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao bookDao;
	

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user){
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
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

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByName(name);
	}
	public User fetchUserWithBook(int id) {
		return userDao.fetchUserWithBook(id);
	}
	

  	public void buyBook(Principal principal, String id) {
		User user = userDao.findOne(Integer.parseInt(principal.getName()));
		
		Book book = bookDao.findOne(Integer.parseInt(id));
		
		user.getBooks().add(book);
		
	}

	

}
