package ua.com.library.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.BookDao;
import ua.com.library.entity.Book;

@Repository
public class BookDaoImpl extends GeneralDaoImpl<Book> implements BookDao{

	@PersistenceContext(unitName="primary")
	private EntityManager entityManager; 
	
	@Transactional
	public Book findOne(String title) {
		return (Book) entityManager.createQuery("select b from Book b where b.title like :title")
				.setParameter("title", title).getSingleResult();
			
	}
	
	@Transactional
	public void delete(String title) {
		entityManager.remove(findOne(title));;
	}
	
	@Transactional
	public Book findBookWithUsers(String title) {
		return (Book) entityManager.createQuery
				("select b from Book b left join fetch b.users "
						+ "where b.title like :title")
				.setParameter("title", title).getSingleResult();
		
	}
}
