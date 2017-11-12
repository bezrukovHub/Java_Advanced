package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ua.com.library.dto.CityDTO;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.CountryEditor;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.service.CityService;
import ua.com.library.service.CountryService;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/newCity", method = RequestMethod.GET)
    public String newCity(Model model) {
        model.addAttribute("countries", DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll()));
        return "views-admin-newCity";
    }

    @RequestMapping(value = "/saveCity", method = RequestMethod.POST)
    public @ResponseBody boolean saveCity(@RequestBody City city) {


        cityService.save(city);

        return true;
    }

    @RequestMapping(value = "/loadCity", method = RequestMethod.POST)
    public @ResponseBody List<CityDTO> saveCity() {


       return DtoUtilMapper.cityToCityDTO(cityService.findAll());

    }


}
