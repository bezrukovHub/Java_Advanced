package cookbook.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cookbook.entity.Dish;
import cookbook.service.DishService;

/**
 * Created by admin on 11/10/2016.
 */
public class DishtValidator implements Validator {

    private final DishService dishService;

	public DishtValidator(DishService dishService) {
		super();
		this.dishService = dishService;
	}

	public boolean supports(Class<?> o) {
		return o.equals(Dish.class);
	}

	public void validate(Object o, Errors errors) {

		Dish dish = (Dish) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "" , "name can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recipe", "" , "resipe can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "story", "" , "story can't be empty");
		
		if(dishService.findByName(dish.getName()) != null){
			errors.rejectValue("name", "", "already exist");
		}
		
		
	}

    
}
