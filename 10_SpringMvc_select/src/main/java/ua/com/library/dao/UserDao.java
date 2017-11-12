package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
