package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Country;

public interface CountryService {

	void save(Country country);

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	Country findCountryWithCities(int id);

}
