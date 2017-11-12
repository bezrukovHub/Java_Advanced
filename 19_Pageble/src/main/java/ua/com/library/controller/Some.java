package ua.com.library.controller;

/**
 * Created by admin on 28.12.2016.
 */
public interface Some {

    abstract void some();


    default void some(int a) {
        System.out.println("lalalallal");
    }

}
