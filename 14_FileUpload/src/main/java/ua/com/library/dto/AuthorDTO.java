package ua.com.library.dto;

public class AuthorDTO {

	private int id;
	private String surname;
	
	public AuthorDTO() {
		// TODO Auto-generated constructor stub
	}

	public AuthorDTO(int id, String surname) {
		super();
		this.id = id;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
}
