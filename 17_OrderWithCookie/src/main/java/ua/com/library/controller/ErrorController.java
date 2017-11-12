package ua.com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 11.12.2016.
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/sale", method = RequestMethod.GET)
    public String error404(Model model){
        model.addAttribute("error", "error message");
        return "views-error-error404";
    }

}
