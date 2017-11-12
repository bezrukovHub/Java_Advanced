package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.BookService;

public class BookEditor extends PropertyEditorSupport {

	private final BookService bookService;

	public BookEditor(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(bookService.findOne(Integer.parseInt(text)));
	}

}
