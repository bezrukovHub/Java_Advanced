package cookbook.dto;

import java.util.ArrayList;
import java.util.List;

import cookbook.entity.Dish;

public class DtoUtilMapper {

	static DishDto dishToDishDto(Dish dish){
		return new DishDto(dish.getName());
	}
	
	public static List<DishDto> dishesToDishesDto(List<Dish> dishs){
		List<DishDto> dishDtos = new ArrayList<>();
		for (Dish dish : dishs) {
			dishDtos.add(new DishDto(dish.getName()));
		}
		
		return dishDtos;
	}
	
	
	
}
