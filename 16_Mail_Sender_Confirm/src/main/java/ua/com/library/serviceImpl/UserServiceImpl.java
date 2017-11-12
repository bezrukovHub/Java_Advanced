package ua.com.library.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;
import ua.com.library.dao.BookDao;
import ua.com.library.dao.UserDao;
import ua.com.library.entity.Book;
import ua.com.library.entity.Role;
import ua.com.library.entity.User;
import ua.com.library.service.MailSenderService;
import ua.com.library.service.UserService;
import ua.com.library.validator.Validator;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao bookDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user) throws Exception {
		
		validator.validate(user);
		
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

	@Transactional
	public void buyBook(Principal principal, String id) {
		User user = userDao.findOne(Integer.parseInt(principal.getName()));
		
		Book book = bookDao.findOne(Integer.parseInt(id));
		
		user.getBooks().add(book);
		
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/"
				+ user.getName() + "/" + multipartFile.getOriginalFilename();

		user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory
						(new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}

	@Override
	public User fetchUserWithBook(int id) {
		return userDao.fetchUserWithBook(id);
	}


	@Override
	public User findByUUID(String uuid) {
		return userDao.findByUUID(uuid);
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}
}
