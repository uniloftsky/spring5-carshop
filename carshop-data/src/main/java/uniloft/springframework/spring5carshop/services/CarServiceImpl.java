package uniloft.springframework.spring5carshop.services;

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
        if (carOptional.isEmpty()) {
            throw new RuntimeException("Expected car not found!");
        }
        return carOptional.get();
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Long getCarsCount() {
        return carRepository.count();
    }

    @Override
    public Set<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Set<Car> findCars(BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCars(minPrice, maxPrice);
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
    public Set<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(brandName, modelName, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByModel_ModelNameAndBody_BodyName(List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByModel_ModelNameAndBody_BodyName(modelName, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByBrand_BrandName(List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByBrand_BrandName(brandName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByBrand_BrandNameAndModel_ModelName(List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByBrand_BrandNameAndModel_ModelName(brandName, modelName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByModel_ModelName(List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByModel_ModelName(modelName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByBody_BodyName(List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByBody_BodyName(bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByBrand_BrandNameAndBody_BodyName(List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByBrand_BrandNameAndBody_BodyName(brandName, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByEngine_Type_Description(List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByEngine_Type_Description(engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandName(List<String> engineType, List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByEngine_Type_DescriptionAndBrand_BrandName(engineType, brandName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByEngine_Type_DescriptionAndModel_ModelName(List<String> engineType, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByEngine_Type_DescriptionAndModel_ModelName(engineType, modelName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByEngine_Type_DescriptionAndBody_BodyName(List<String> engineType, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByEngine_Type_DescriptionAndBody_BodyName(engineType, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndModel_ModelName(List<String> engineType, List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndModel_ModelName(engineType, brandName, modelName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyName(List<String> engineType, List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyName(engineType, brandName, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyNameAndModel_ModelName(List<String> engineType, List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyNameAndModel_ModelName(engineType, brandName, modelName, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeName(List<String> carType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeName(carType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndEngine_Type_Description(List<String> carType, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndEngine_Type_Description(carType, engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBrand_BrandName(List<String> carType, List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBrand_BrandName(carType, brandName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndModel_ModelName(List<String> carType, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndModel_ModelName(carType, modelName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBody_BodyName(List<String> carType, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBody_BodyName(carType, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelName(List<String> carType, List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelName(carType, brandName, modelName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyName(List<String> carType, List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyName(carType, brandName, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyName(List<String> carType, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyName(carType, modelName, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> carType, List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyName(carType, brandName, modelName, bodyName, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBrand_BrandNameAndEngine_Type_Description(carType, brandName, engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndEngine_Type_Description(List<String> carType, List<String> modelName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndModel_ModelNameAndEngine_Type_Description(carType, modelName, engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBody_BodyNameAndEngine_Type_Description(carType, bodyName, engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> modelName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndEngine_Type_Description(carType, brandName, modelName, engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyNameAndEngine_Type_Description(carType, brandName, bodyName, engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> modelName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(carType, modelName, bodyName, engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(List<String> carType, List<String> brandName, List<String> modelName, List<String> bodyName, List<String> engineType, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(carType, brandName, modelName, bodyName, engineType, minPrice, maxPrice);
    }

    @Override
    public Set<Car> findCarsByEngine_Type_DescriptionAndModel_ModelNameAndBody_BodyName(List<String> engineType, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice) {
        return carRepository.findCarsByEngine_Type_DescriptionAndModel_ModelNameAndBody_BodyName(engineType, modelName, bodyName, minPrice, maxPrice);
    }
}
