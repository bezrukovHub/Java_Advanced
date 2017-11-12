package ua.com.library.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.GeneralDao;

public class GeneralDaoImpl <T> implements GeneralDao<T>{

	@PersistenceContext(unitName="primary")
	private EntityManager entityManager;
	
	private Class<T> entity;
	
	@Transactional
	public void save(T t) {
		entityManager.persist(t);
	}
	@Transactional
	public List<T> findAll() {
		return entityManager.createQuery("from "+entity.getClass().getSimpleName()).getResultList();
	}

	@Transactional
	public void update(T t) {
		entityManager.merge(t);
	}

	
	
}
