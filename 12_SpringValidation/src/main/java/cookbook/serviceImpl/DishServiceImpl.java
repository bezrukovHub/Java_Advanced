package cookbook.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cookbook.entity.Dish;
import cookbook.repository.DishRepository;
import cookbook.service.DishService;

/**
 * Created by koko on 12.10.16.
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    public void save(Dish dish) {
        dishRepository.save(dish);
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Dish findOne(int id) {
        return dishRepository.findOne(id);
    }

    public void delete(int id) {
        dishRepository.delete(id);
    }

	public Dish findByName(String name) {
		return dishRepository.findByName(name);
	}
    

   
}
