package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	
	User findByName(String name);
	
	@Query("select distinct u from User u left join fetch u.books where u.id =:id")
	User fetchUserWithBook(@Param("id") int id);
	
	
}
