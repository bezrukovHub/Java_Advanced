package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.editor.CountryEditor;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.service.CityService;
import ua.com.library.service.CountryService;

@Controller
public class CityController {

	@Autowired
	private CityService cityService;
	@Autowired
	private CountryService countryService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
	}

	@RequestMapping(value = "/newCity", method = RequestMethod.GET)
	public String newCity(Model model) {

		model.addAttribute("city", new City());
		model.addAttribute("countries", countryService.findAll());
		return "views-admin-newCity";
	}

	@RequestMapping(value = "/saveCity", method = RequestMethod.POST)
	public String saveCity(@ModelAttribute City city) {

		cityService.save(city);

		return "redirect:/newCity";
	}

}
