package ua.com.library.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.AuthorDao;
import ua.com.library.entity.Author;


@Repository
public class AuthorDaoImpl implements AuthorDao{

	@PersistenceContext(unitName="primary")
	private EntityManager entityManager;
	@Transactional
	public void save(Author author) {
		entityManager.persist(author);
	}
	@Transactional
	public List<Author> findAll() {
		return entityManager.createQuery("from Author").getResultList();
	}
	@Transactional
	public Author findOne(String surname) {
		return (Author) entityManager.createQuery
				("select a from Author a where a.surnmae like :surname")
				.setParameter("surnmae", surname).getSingleResult();
	}
	@Transactional
	public void delete(String surname) {
		entityManager.remove(findOne(surname));
	}
	
	
	
	
}
