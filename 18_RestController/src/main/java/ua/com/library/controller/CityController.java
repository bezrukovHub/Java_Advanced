package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ua.com.library.dto.CityDTO;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.City;
import ua.com.library.service.CityService;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/saveCity", method = RequestMethod.POST)
    public void saveCity(@RequestBody City city){

        cityService.save(city);


    }


}
