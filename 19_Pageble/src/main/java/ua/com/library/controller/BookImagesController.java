package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.library.service.BookImageService;
import ua.com.library.service.BookService;

/**
 * Created by admin on 23.12.2016.
 */
@Controller
public class BookImagesController {


    @Autowired
    private BookImageService bookImageService;
    @Autowired
    private BookService bookService;

    @GetMapping("/addImages/{idBook}")
    public String addImage(@PathVariable String idBook, Model model){

        model.addAttribute("book", bookService.findOne(Integer.parseInt(idBook)));

        return "views-base-addBookImage";
    }




    @PostMapping("/saveManyImages/{idBook}")
    public String saveManyImages(@PathVariable String idBook, @RequestParam MultipartFile[] images){

        bookImageService.saveImage(Integer.parseInt(idBook), images);


        return "redirect:/";

    }


}
