package ua.com.library.controller;

import ua.com.library.entity.Book;
import ua.com.library.entity.Role;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by admin on 28.12.2016.
 */
public class Engine extends Exception{

    public Engine(String message) {
        super(message);
    }

    public void start() throws FileNotFoundException {

        Set<Book> books = new HashSet<>();


        throw new FileNotFoundException();

    }

    public void some1(){
        try {
            start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
