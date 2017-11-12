package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import ua.com.library.entity.Book;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

	@Query("select b from Book b where b.pages >= :value")
    List<Book> sortBooks(@Param("value") int value);
	
}
