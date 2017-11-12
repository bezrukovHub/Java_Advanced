package ua.com.library.dao;

		import org.springframework.data.jpa.repository.JpaRepository;

		import org.springframework.data.jpa.repository.Query;
		import org.springframework.data.repository.query.Param;
		import ua.com.library.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {


	User findByName(String name);
	User findByPhone(String phone);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email =:email")
	boolean userExistsByEmail(@Param("email") String email);


	@Query("select distinct u from User u left join fetch u.books where u.id =:id")
	User fetchUserWithBook(@Param("id") int id);

	@Query("select u from User u where u.uuid =:uuid")
	User findByUUID(@Param("uuid") String uuid);

}
