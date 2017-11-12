package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.AuthorService;

public class AuthorEditor extends PropertyEditorSupport{
	
	private final AuthorService authorService;

	public AuthorEditor(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(authorService.findOne(Integer.parseInt(text)));
	}
	
}
