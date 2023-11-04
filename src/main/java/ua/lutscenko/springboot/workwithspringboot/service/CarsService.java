package ua.lutscenko.springboot.workwithspringboot.service;

import ua.lutscenko.springboot.workwithspringboot.model.Car;

import java.util.List;

public interface CarsService {
    Car save(Car car);

    List<Car> findAll();
}
