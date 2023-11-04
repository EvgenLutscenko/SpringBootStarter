package ua.lutscenko.springboot.workwithspringboot.repository.repoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.lutscenko.springboot.workwithspringboot.model.CarFactory;
import ua.lutscenko.springboot.workwithspringboot.repository.CarsFactoriesRepository;

import java.util.List;

@Repository
public class CarsFactoryRepositoryImpl implements CarsFactoriesRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public CarsFactoryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CarFactory save(CarFactory factory) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.persist(factory);
                transaction.commit();
                return factory;
            }catch (Exception e){
                if(transaction != null){
                    transaction.rollback();
                }
                throw new RuntimeException("Can't save car: " + factory + " to DB", e);
            }
        }
    }

    @Override
    public List<CarFactory> findAll() {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("from CarFactory ").list();
        }catch (Exception e){
            throw new RuntimeException("Can't get all cars from DB", e);
        }
    }
}
