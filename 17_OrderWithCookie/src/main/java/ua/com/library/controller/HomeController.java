package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ua.com.library.dto.BookDTO;
import ua.com.library.dto.CityDTO;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.BookEditor;
import ua.com.library.entity.Book;
import ua.com.library.entity.User;
import ua.com.library.service.BookService;
import ua.com.library.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Book.class, new BookEditor(bookService));
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model, Principal principal) {
		model.addAttribute("books", bookService.findAll());
		return "views-base-home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocesing() {
		return "redirect:/home";
	}

	@RequestMapping("/loginpage")
	public String login() {
		return "views-base-loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}

	@RequestMapping(value = "/some", method = RequestMethod.GET)
	public String some() {

		return "redirect:/HTMLpages/some.html";
	}

	@Transactional
	@RequestMapping(value = "/getBooks", method = RequestMethod.POST)
	public @ResponseBody String  getBooks(@RequestBody String  checked, Principal principal){

		/*User user = userService.findOne(Integer.parseInt(principal.getName()));

		for (String s : checked) {
			Book book = bookService.findOne(Integer.parseInt(s));

			book.getUsers().add(user);
		}*/
		return "from controller";

	}

	@RequestMapping(value = "/sortBooks", method = RequestMethod.POST)
	public @ResponseBody List<BookDTO> sortBooks(@RequestBody String value){

		List<Book> books = bookService.sortBooks(Integer.parseInt(value));


		return DtoUtilMapper.booksToBooksDTO(books);
	}





}
