package cookbook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cookbook.entity.Dish;
import cookbook.service.DishService;
import cookbook.validation.DishtValidator;

/**
 * Created by koko on 14.10.16.
 */
@Controller
public class DishController {

    @Autowired
    private DishService dishService;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder){
    	binder.setValidator(new DishtValidator(dishService));
    }

    @RequestMapping(value = "/newDish", method = RequestMethod.GET)
    public String dish(Model model){
        model.addAttribute("dish", new Dish());
        return "dish";
    }

    @RequestMapping(value = "/newDish", method = RequestMethod.POST)
    public String newDish(@ModelAttribute @Valid Dish dish, BindingResult bindingResult){
    	
    	if(bindingResult.hasErrors()){
    		return "dish";
    	}
    	   	
        dishService.save(dish);
        return "redirect:/dish";
    }

}
