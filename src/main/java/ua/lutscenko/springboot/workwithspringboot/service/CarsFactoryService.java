package ua.lutscenko.springboot.workwithspringboot.service;

import ua.lutscenko.springboot.workwithspringboot.model.CarFactory;

import java.util.List;

public interface CarsFactoryService {
    CarFactory save(CarFactory carFactory);

    List<CarFactory> findAll();
}
