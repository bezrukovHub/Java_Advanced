package ua.com.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ua.com.library.dto.BookDTO;
import ua.com.library.dto.CityDTO;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.BookEditor;
import ua.com.library.editor.CountryEditor;
import ua.com.library.entity.Book;
import ua.com.library.entity.Country;
import ua.com.library.entity.User;
import ua.com.library.service.BookService;
import ua.com.library.service.CityService;
import ua.com.library.service.CountryService;
import ua.com.library.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BookService bookService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Book.class, new BookEditor(bookService));
        binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model, Principal principal) {

        model.addAttribute("book", bookService.findAll());
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
    public
    @ResponseBody
    List<BookDTO> addBook(@RequestBody Book book) {

        System.out.println("some");

        bookService.save(book);

        return DtoUtilMapper.booksToBooksDTO(bookService.findAll());
    }


    @PostMapping("/sortBookByCountry")
    public
    @ResponseBody
    List<BookDTO> sortBookByCountry(@RequestBody String idCountry) {

        List<Book> books = bookService.sortBookByCountry(Integer.parseInt(idCountry));


        return DtoUtilMapper.booksToBooksDTO(books);

    }


    @RequestMapping(value = "/saveBookLA", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @PostMapping("/failLogin")
    public String failLogin(Model model, @RequestParam String username,
                            @RequestParam String password) {

        User user = userService.findByName(username);

        if (encoder.matches(user.getPassword(), password)) {
            return "redirect:/";
        }

        model.addAttribute("fail", "fail");

        return "views-base-loginpage";
    }

    @PostMapping("/newBook")
    public void newBook (@RequestBody Book  book){
        bookService.save(book);
    }



}
