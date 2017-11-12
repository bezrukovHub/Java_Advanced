package cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cookbook.dto.DtoUtilMapper;
import cookbook.service.DishService;

/**
 * Created by koko on 14.10.16.
 */
@Controller
public class HomeController {

    
    @Autowired
    private DishService dishService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model){
    	model.addAttribute("dishes", DtoUtilMapper.dishesToDishesDto(dishService.findAll()));
        return "home";
    }


  

}
