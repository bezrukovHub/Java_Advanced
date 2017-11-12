package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ua.com.library.dto.CountryDTO;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Country;
import ua.com.library.service.CountryService;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/loadCountries", method = RequestMethod.POST)
    public List<CountryDTO> loadCountries() {

        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
    public List<CountryDTO> saveCountry(@RequestBody Country country) {

        countryService.save(country);

        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }

    @RequestMapping(value = "/deleteCountry", method = RequestMethod.POST)
    public List<CountryDTO> loadCountries(@RequestBody String index) {

        countryService.delete(Integer.parseInt(index));

        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }

}