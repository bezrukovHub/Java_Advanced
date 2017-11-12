package ua.com.library.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.library.entity.*;

public class DtoUtilMapper {

	public static List<UserDTO> usersToUsersDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		for (User user : users) {

			UserDTO userDTO = new UserDTO();
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			userDTO.setName(user.getPhone());

			userDTOs.add(userDTO);

		}

		return userDTOs;

	}

	public static List<BookDTO> booksToBooksDTO(List<Book> books) {

		List<BookDTO> bookDTOs = new ArrayList<BookDTO>();

		for (Book book : books) {
			BookDTO bookDTO = new BookDTO();

			bookDTO.setTitle(book.getTitle());
			bookDTO.setPages(book.getPages());

			bookDTOs.add(bookDTO);

		}

		return bookDTOs;

	}
	
	
	public static List<AuthorDTO> authorsToAuthorsDTOs(List<Author> authors){
		
		List<AuthorDTO> authorDTOs = new ArrayList<AuthorDTO>();
		
		for(Author author : authors){
			authorDTOs.add(new AuthorDTO(author.getId(), author.getSurname()));
		}
		
		return authorDTOs;
	
	}
	
	
	public static List<CountryDTO> countriesToCountriesDTOs(List<Country> countries){
		
		List<CountryDTO> countryDTOs = new ArrayList<CountryDTO>();
		
		for(Country country : countries){
			countryDTOs.add(new CountryDTO(country.getId(), country.getName()));
		}
		return countryDTOs;
	}

	public static List<CityDTO> cityToCityDTO(List<City> cities){

		List<CityDTO> cityDTOs = new ArrayList<>();

		for (City city : cities) {

			cityDTOs.add(new CityDTO( city.getId(),city.getName()));
		}

		return cityDTOs;

	}


}
