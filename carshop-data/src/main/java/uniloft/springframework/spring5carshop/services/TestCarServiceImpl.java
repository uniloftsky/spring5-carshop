package uniloft.springframework.spring5carshop.services;

import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.model.TestCar;
import uniloft.springframework.spring5carshop.services.repositories.TestCarRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestCarServiceImpl implements TestCarService {

    private final TestCarRepository testCarRepository;

    public TestCarServiceImpl(TestCarRepository testCarRepository) {
        this.testCarRepository = testCarRepository;
    }

    @Override
    public Set<TestCar> getBuyCars() {
        Set<TestCar> testCars = new HashSet<>();
        testCarRepository.findAll().iterator().forEachRemaining(testCars::add);
        return testCars;
    }

    @Override
    public TestCar save(TestCar testCar, Customer customer, Car car) {
        testCar.setCustomer(customer);
        testCar.setCar(car);
        testCar.setDate(LocalDate.now());
        testCar.setCount(1);
        testCar.setPrice(car.getTestPrice());
        return testCarRepository.save(testCar);
    }

    @Override
    public TestCar findById(Long id) {
        Optional<TestCar> buyCarOptional = testCarRepository.findById(id);
        if(buyCarOptional.isEmpty()) {
            throw new RuntimeException("Expected buycar not found!");
        }
        return buyCarOptional.get();
    }

    @Override
    public void delete(TestCar testCar) {
        testCarRepository.delete(testCar);
    }
}
