package ua.com.library.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.UserDao;
import ua.com.library.entity.User;

@Repository
public class UserDaoImpl extends GeneralDaoImpl<User> implements UserDao {

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;


	
	@Transactional
	public User findOne(String username) {
		return (User) entityManager.createNamedQuery("User.findByUsername").setParameter("username", username)
				.getSingleResult();
	}

	@Transactional
	public void delete(String username) {
		entityManager.remove(findOne(username));
	}

	@Transactional
	public User findUserWithBooks(String username) {
		return (User) entityManager
				.createQuery("select u from User u left join fetch u.books where u.username like :username")
				.setParameter("username", username).getSingleResult();
	}

}
