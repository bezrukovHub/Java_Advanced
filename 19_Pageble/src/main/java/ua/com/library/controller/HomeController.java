package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ua.com.library.dto.BookDTO;
import ua.com.library.dto.CityDTO;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.BookEditor;
import ua.com.library.entity.Book;
import ua.com.library.service.BookService;
import ua.com.library.service.CityService;
import ua.com.library.service.CountryService;

import java.security.Principal;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Book.class, new BookEditor(bookService));
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {

        Page<Book> books = bookService.findAll(0, 5);

        String pages = "";

        for(int i = 0; i < books.getTotalPages(); i++){

            pages+= i+ "-";

        }
        //0-1-2-3-4-5-6

        model.addAttribute("totalPages", books.getTotalPages());

        model.addAttribute("pages", pages);
        model.addAttribute("books", books);

        return "views-base-home";
    }

    @GetMapping("/pageable/{currentPage}/{totalElement}")
    public String pageable(@PathVariable int currentPage, @PathVariable int totalElement, Model model) {










        Page<Book> books = bookService.findAll(currentPage, totalElement);

        List<BookDTO> bookDTOS = DtoUtilMapper.booksToBooksDTO(books.getContent());


        String pages = "";

        for(int i = 0; i < books.getTotalPages(); i++){

            pages+= i+ "-";
        }

        model.addAttribute("totalPages", books.getTotalPages());

        model.addAttribute("pages", pages);

        model.addAttribute("books", books);

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

    @RequestMapping(value = "/getBooks", method = RequestMethod.POST)
    public void getBooks(@RequestBody String[] arr, Principal principal) {

        for (String s : arr) {
            System.out.println(s);
        }

    }


    @RequestMapping(value = "/getCities", method = RequestMethod.POST)
    public
    @ResponseBody
    List<CityDTO> getBooks(@RequestBody String id) {

        System.out.println(countryService.findCountryWithCities(Integer.parseInt(id)));
        ;
        System.out.println(DtoUtilMapper.cityToCityDTO(cityService.getAllCitiesByCountryId(Integer.parseInt(id)).getCities()));

        return DtoUtilMapper.cityToCityDTO(cityService.getAllCitiesByCountryId(Integer.parseInt(id)).getCities());


    }

    @RequestMapping(value = "/sortBooks", method = RequestMethod.POST)
    public
    @ResponseBody
    List<BookDTO> sortBooks(@RequestBody String index) {


        List<Book> bookList = bookService.sortBooks(Integer.parseInt(index));

        return DtoUtilMapper.booksToBooksDTO(bookList);


    }

    @RequestMapping(value = "/liveSearchBooks", method = RequestMethod.POST)
    public
    @ResponseBody
    List<BookDTO> liveSearchBooks(@RequestBody String search) {

        System.out.println(search);

        System.out.println(bookService.liveSearch(search));
        for (Book book : bookService.liveSearch(search)) {
            System.out.println(book);
        }

        List<Book> bookList = bookService.liveSearch(search);

        return DtoUtilMapper.booksToBooksDTO(bookList);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book) {

        System.out.println("some");

        bookService.save(book);


    }


    @RequestMapping(value = "/loadBooks", method = RequestMethod.POST)
    public @ResponseBody String loadBooks(){

        Page<Book> books = bookService.findAll(0, 5);

        return String.valueOf(books.getTotalPages());
    }




}
