package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.library.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer>{

    @Query("select c from Country c left join fetch c.cities where c.id =:id")
    Country findCountryWithCities(@Param("id") int id);

}
