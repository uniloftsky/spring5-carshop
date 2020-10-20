package uniloft.springframework.spring5carshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.comparators.CarComparatorImpl;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public TreeSet<Car> getSortedCars() {
        Comparator<Car> comparator = new CarComparatorImpl();
        Set<Car> cars = new HashSet<>();
        carRepository.findAll().iterator().forEachRemaining(cars::add);
        TreeSet<Car> set = new TreeSet<>(comparator);
        cars.stream().iterator().forEachRemaining(set::add);
        Set<Car> sortedSet = set.stream().limit(3).collect(Collectors.toSet());
        TreeSet<Car> finalSet = new TreeSet<>(comparator);
        sortedSet.stream().iterator().forEachRemaining(finalSet::add);
        return finalSet;
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
