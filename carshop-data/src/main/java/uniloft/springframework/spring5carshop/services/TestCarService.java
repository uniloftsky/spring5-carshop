package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.model.TestCar;

import java.util.Set;

public interface TestCarService {

    Set<TestCar> getTestCars();
    TestCar save(TestCar buyCar, Customer customer, Car car);
    TestCar findById(Long id);
    void delete(TestCar buyCar);

}
