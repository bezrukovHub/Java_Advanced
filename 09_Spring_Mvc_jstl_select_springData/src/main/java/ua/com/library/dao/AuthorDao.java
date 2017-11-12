package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Author;

public interface AuthorDao extends JpaRepository<Author, Integer>{
	
}
	 