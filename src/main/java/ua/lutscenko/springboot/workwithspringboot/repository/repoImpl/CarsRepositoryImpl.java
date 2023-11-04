package ua.lutscenko.springboot.workwithspringboot.repository.repoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.lutscenko.springboot.workwithspringboot.model.Car;
import ua.lutscenko.springboot.workwithspringboot.repository.CarsRepository;

import java.util.List;

@Repository
public class CarsRepositoryImpl implements CarsRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public CarsRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car save(Car car) {
        try (Session session = sessionFactory.openSession();){
            Transaction transaction = session.beginTransaction();
            try{
                session.persist(car);
                transaction.commit();
                return car;
            }catch (Exception e){
                if(transaction != null){
                    transaction.rollback();
                }
                throw new RuntimeException("Can't save car: " + car + " to DB", e);
            }
        }
    }

    @Override
    public List<Car> findAll() {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("from Car").list();
        }catch (Exception e){
            throw new RuntimeException("Can't get all cars from DB", e);
        }
    }
}
