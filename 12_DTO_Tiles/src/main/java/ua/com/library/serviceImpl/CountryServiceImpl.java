package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.library.dao.CountryDao;
import ua.com.library.entity.Country;
import ua.com.library.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao;

	public void save(Country country) {
		countryDao.save(country);
	}

	public List<Country> findAll() {
		return countryDao.findAll();
	}

	public Country findOne(int id) {
		return countryDao.findOne(id);
	}

	public void delete(int id) {
		countryDao.delete(id);
	}
	
	
	
}
