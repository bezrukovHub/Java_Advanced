package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer>{

}
