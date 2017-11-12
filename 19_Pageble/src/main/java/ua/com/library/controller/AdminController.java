package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.service.CountryService;

@Controller
public class AdminController {

	@Autowired
	private CountryService countryService;


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String newAuthor(Model model) {
		return "views-admin-admin";
	}

	@RequestMapping(value = "/newCountry", method = RequestMethod.GET)
	public String saveCountry(){

		return "views-admin-newCountry";
	}

	@RequestMapping(value = "/newCity", method = RequestMethod.GET)
	public String newCity(Model model) {
		model.addAttribute("countries", DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll()));
		return "views-admin-newCity";
	}

}
