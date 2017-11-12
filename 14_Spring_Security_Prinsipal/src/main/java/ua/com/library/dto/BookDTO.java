package ua.com.library.dto;

public class BookDTO {

	private String title;
	private int pages;
	
	public BookDTO() {
	}

	public BookDTO(String title, int pages) {
		super();
		this.title = title;
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", pages=" + pages + "]";
	}
	
	
	
}
