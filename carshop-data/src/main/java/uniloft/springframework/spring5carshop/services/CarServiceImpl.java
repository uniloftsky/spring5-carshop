package uniloft.springframework.spring5carshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;

import java.util.HashSet;
import java.util.Optional;
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

    @Override
    public Car findById(Long id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if(carOptional.isEmpty()) {
            throw new RuntimeException("Expected car not found!");
        }
        return carOptional.get();
    }

    @Override
    public Long getCarsCount() {
        return carRepository.count();
    }

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
}
