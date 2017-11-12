package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.library.dao.CityDao;
import ua.com.library.entity.City;
import ua.com.library.service.CityService;
@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao cityDao;

	public void save(City city) {
		cityDao.save(city);
	}

	public List<City> findAll() {
		return cityDao.findAll();
	}

	public City findOne(int id) {
		return cityDao.findOne(id);
	}

	public void delete(int id) {
		cityDao.delete(id);
	}
	
	
	
}
