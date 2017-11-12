package ua.com.library.dto;

public class CountryDTO {

	private int id;
	private String name;

	public CountryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CountryDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
