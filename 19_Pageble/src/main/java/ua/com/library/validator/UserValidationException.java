package ua.com.library.validator;

import ua.com.library.entity.Book;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class UserValidationException extends Exception {

    public UserValidationException(String msg) {
        super(msg);


    }

}
