package ua.com.library.controller;

import ua.com.library.entity.Role;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 28.12.2016.
 */
public class Car implements Some,Some2{

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void some() {



    }

    @Override
    public void some(int a) {

    }
}
