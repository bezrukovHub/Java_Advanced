package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.com.library.dto.BookDTO;
import ua.com.library.dto.CityDTO;
import ua.com.library.dto.CountryDTO;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Country;
import ua.com.library.service.CountryService;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/newCountry", method = RequestMethod.GET)
    public String saveCountry(){

       return "views-admin-newCountry";
    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
    public @ResponseBody List<CountryDTO> saveCountry(@RequestBody Country country){

        countryService.save(country);

        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }

    @RequestMapping(value = "/loadCountries", method = RequestMethod.POST)
    public @ResponseBody List<CountryDTO> loadCountries(){


        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }

    @RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.POST)
    public @ResponseBody List<CountryDTO> loadCountries(@PathVariable String id){

        countryService.delete(Integer.parseInt(id));

        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }



}
