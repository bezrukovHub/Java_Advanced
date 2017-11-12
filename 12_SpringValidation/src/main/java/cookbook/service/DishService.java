package cookbook.service;

import java.util.List;

import cookbook.entity.Dish;

/**
 * Created by koko on 12.10.16.
 */
public interface DishService {
    void save(Dish dish);
    List<Dish> findAll();
    Dish findOne(int id);
    void delete(int id);
    Dish findByName(String name);
}
