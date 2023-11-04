package ua.lutscenko.springboot.workwithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ua.lutscenko.springboot.workwithspringboot.model.Car;
import ua.lutscenko.springboot.workwithspringboot.model.CarFactory;
import ua.lutscenko.springboot.workwithspringboot.service.serviceImpl.CarsFactoryServiceImpl;
import ua.lutscenko.springboot.workwithspringboot.service.serviceImpl.CarsServiceImpl;

import java.util.List;

@SpringBootApplication
public class WorkWithSpringBootApplication {
    @Autowired
    private CarsServiceImpl carsService;

    @Autowired
    private CarsFactoryServiceImpl carsFactoryService;

    public static void main(String[] args) {
        SpringApplication.run(WorkWithSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            CarFactory factory = CarFactory.builder()
                    .location("Germany")
                    .build();
            Car mercedes = Car.builder()
                    .model("mercedes")
                    .saleContry("Ukraine")
                    .carFactory(factory)
                    .build();
            Car volkswagen = Car.builder()
                    .model("volkswagen")
                    .saleContry("Ukraine")
                    .carFactory(factory)
                    .build();
            Car volkswagen2 = Car.builder()
                    .model("volkswagen2")
                    .saleContry("Ukraine")
                    .carFactory(factory)
                    .build();
            Car volkswagen3 = Car.builder()
                    .model("volkswagen3")
                    .saleContry("Ukraine")
                    .carFactory(factory)
                    .build();
            Car volkswagen4 = Car.builder()
                    .model("volkswagen4")
                    .saleContry("Ukraine")
                    .carFactory(factory)
                    .build();

            carsFactoryService.save(factory);
            carsService.save(mercedes);
            carsService.save(volkswagen);
            carsService.save(volkswagen2);
            carsService.save(volkswagen3);
            carsService.save(volkswagen4);


            List<Car> cars = carsService.findAll();
            List<CarFactory> carFactories = carsFactoryService.findAll();

            for (CarFactory carFactory : carFactories){
                System.out.println(carFactory);
            }

            for (Car car : cars){
                System.out.println(car);
            }
        };
    }

}
