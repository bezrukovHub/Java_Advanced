package ua.com.buy_me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by koko on 27.10.16.
 */
@Controller
public class Homecontroller {


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(){
        return "views-base-home";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(){
        return "views-base-order";
    }

}
