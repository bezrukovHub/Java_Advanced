package ua.com.library.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;

public interface CityService {

	void save(City city);
	List<City> findAll();
	City findOne(int id);
	void delete(int id);
	Country getAllCitiesByCountryId(int id);
	
}
