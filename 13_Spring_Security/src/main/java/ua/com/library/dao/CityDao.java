package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
