package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;

import java.util.List;

public interface CityDao extends JpaRepository<City, Integer>{



    @Query("select c from Country c left join fetch c.cities where c.id =:id")
    Country getAllCitiesByCountryId(@Param("id") int id);

}
