package ua.com.library.dao;

		import org.springframework.data.jpa.repository.JpaRepository;

		import org.springframework.data.jpa.repository.Query;
		import org.springframework.data.repository.query.Param;
		import ua.com.library.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {


	User findByName(String name);
	User findByPhone(String phone);


	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.name =:name")
	boolean userExistsByName(@Param("name") String name);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email =:email")
	boolean userExistsByEmail(@Param("email") String email);

}
