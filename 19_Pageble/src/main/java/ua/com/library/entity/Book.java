package ua.com.library.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int pages;
	private LocalDate dateOfPublic;

	private String bookImage;

	@ManyToOne
	private Author author;
	@ManyToOne
	private Country country;

	@ManyToMany
	@JoinTable(name = "user_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;


	@OneToMany(mappedBy = "book")
	private List<BookImage> bookImages;




	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, int pages) {
		this.title = title;
		this.pages = pages;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public LocalDate getDateOfPublic() {
		return dateOfPublic;
	}

	public void setDateOfPublic(LocalDate dateOfPublic) {
		this.dateOfPublic = dateOfPublic;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}


	public List<BookImage> getBookImages() {
		return bookImages;
	}

	public void setBookImages(List<BookImage> bookImages) {
		this.bookImages = bookImages;
	}

}
