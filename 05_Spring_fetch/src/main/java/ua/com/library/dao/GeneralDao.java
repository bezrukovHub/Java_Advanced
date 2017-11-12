package ua.com.library.dao;

import java.util.List;

public interface GeneralDao <T> {
	
	void save(T t);
	List<T> findAll();
	void update(T t);
	

}
