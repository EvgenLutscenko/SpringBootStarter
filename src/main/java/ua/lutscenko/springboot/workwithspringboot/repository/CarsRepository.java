package ua.lutscenko.springboot.workwithspringboot.repository;

import org.springframework.stereotype.Repository;
import ua.lutscenko.springboot.workwithspringboot.model.Car;

import java.util.List;

public interface CarsRepository {
    Car save(Car car);

    List<Car> findAll();
}