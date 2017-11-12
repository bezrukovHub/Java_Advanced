package cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cookbook.entity.Dish;

/**
 * Created by koko on 14.10.16.
 */
public interface DishRepository extends JpaRepository<Dish, Integer>{

   Dish findByName(String name);
}
