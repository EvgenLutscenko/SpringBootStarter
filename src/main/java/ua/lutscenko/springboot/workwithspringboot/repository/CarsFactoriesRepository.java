package ua.lutscenko.springboot.workwithspringboot.repository;

import ua.lutscenko.springboot.workwithspringboot.model.CarFactory;

import java.util.List;

public interface CarsFactoriesRepository {
    CarFactory save(CarFactory carFactory);

    List<CarFactory> findAll();
}

