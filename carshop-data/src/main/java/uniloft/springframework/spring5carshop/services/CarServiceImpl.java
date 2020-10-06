package uniloft.springframework.spring5carshop.services;

import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Set<Car> getCars() {
        Set<Car> cars = new HashSet<>();
        carRepository.findAll().iterator().forEachRemaining(cars::add);
        return cars;
    }
}
