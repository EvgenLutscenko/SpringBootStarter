package ua.lutscenko.springboot.workwithspringboot.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lutscenko.springboot.workwithspringboot.model.CarFactory;
import ua.lutscenko.springboot.workwithspringboot.repository.CarsFactoriesRepository;
import ua.lutscenko.springboot.workwithspringboot.repository.repoImpl.CarsFactoryRepositoryImpl;
import ua.lutscenko.springboot.workwithspringboot.service.CarsFactoryService;

import java.util.List;

@Service
public class CarsFactoryServiceImpl implements CarsFactoryService {
    private final CarsFactoriesRepository crasrepo;

    @Autowired
    public CarsFactoryServiceImpl(CarsFactoryRepositoryImpl crasrepo) {
        this.crasrepo = crasrepo;
    }

    @Override
    public CarFactory save(CarFactory carFactory) {
        return crasrepo.save(carFactory);
    }

    @Override
    public List<CarFactory> findAll() {
        return crasrepo.findAll();
    }
}
