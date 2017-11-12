package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.library.service.CountryService;

public class CountryEditor extends PropertyEditorSupport {
	
	private final CountryService countryService;

	public CountryEditor(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		setValue(countryService.findOne(Integer.parseInt(text)));
	
	}
	
	
	
	
	
}
