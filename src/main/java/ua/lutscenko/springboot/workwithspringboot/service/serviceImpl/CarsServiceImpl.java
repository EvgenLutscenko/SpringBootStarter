package ua.lutscenko.springboot.workwithspringboot.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lutscenko.springboot.workwithspringboot.model.Car;
import ua.lutscenko.springboot.workwithspringboot.repository.repoImpl.CarsRepositoryImpl;
import ua.lutscenko.springboot.workwithspringboot.service.CarsService;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    private final CarsRepositoryImpl carRepo;

    @Autowired
    public CarsServiceImpl(CarsRepositoryImpl carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public Car save(Car car) {
        return carRepo.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepo.findAll();
    }
}
