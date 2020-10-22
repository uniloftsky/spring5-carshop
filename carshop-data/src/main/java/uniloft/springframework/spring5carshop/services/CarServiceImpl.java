package uniloft.springframework.spring5carshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.comparators.CarAscendingComparatorByPrice;
import uniloft.springframework.spring5carshop.comparators.CarDescendingComparatorById;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public TreeSet<Car> getSortedCars(Comparator<Car> comparator) {
        comparator = new CarDescendingComparatorById();
        TreeSet<Car> set = new TreeSet<>(comparator);
        carRepository.findAll().iterator().forEachRemaining(set::add);
        return set;
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
        pageable.first();
        return carRepository.findAll(pageable);
    }

    @Override
    public BigDecimal findMinPrice() {
        Comparator<Car> comparator = new CarAscendingComparatorByPrice();
        TreeSet<Car> cars = new TreeSet<>(comparator);
        carRepository.findAll().iterator().forEachRemaining(cars::add);
        return cars.first().getPrice();
    }

    @Override
    public BigDecimal findMaxPrice() {
        Comparator<Car> comparator = new CarAscendingComparatorByPrice();
        TreeSet<Car> cars = new TreeSet<>(comparator);
        carRepository.findAll().iterator().forEachRemaining(cars::add);
        return cars.last().getPrice();
    }

    @Override
    public Page<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(String brandName, String modelName, String bodyName, Pageable pageable) {
        return carRepository.findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(brandName, modelName, bodyName, pageable);
    }

    @Override
    public Page<Car> findCarsByModel_ModelNameAndBody_BodyName(String modelName, String bodyName, Pageable pageable) {
        return carRepository.findCarsByModel_ModelNameAndBody_BodyName(modelName, bodyName, pageable);
    }

    @Override
    public Page<Car> findCarsByBrand_BrandName(String brandName, Pageable pageable) {
        return carRepository.findCarsByBrand_BrandName(brandName, pageable);
    }

    @Override
    public Page<Car> findCarsByBrand_BrandNameAndModel_ModelName(String brandName, String modelName, Pageable pageable) {
        return carRepository.findCarsByBrand_BrandNameAndModel_ModelName(brandName, modelName, pageable);
    }

    @Override
    public Page<Car> findCarsByModel_ModelName(String modelName, Pageable pageable) {
        return carRepository.findCarsByModel_ModelName(modelName, pageable);
    }

    @Override
    public Page<Car> findCarsByBody_BodyName(String bodyName, Pageable pageable) {
        return carRepository.findCarsByBody_BodyName(bodyName, pageable);
    }

    @Override
    public Page<Car> findCarsByBrand_BrandNameAndBody_BodyName(String brandName, String bodyName, Pageable pageable) {
        return carRepository.findCarsByBrand_BrandNameAndBody_BodyName(brandName, bodyName, pageable);
    }
}
